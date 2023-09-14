#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define MAX_PACIENTES 16
#define NUM_MEDICOS 2
#define NUM_NEBULIZADORES 4

sem_t sem_medicos;
sem_t sem_nebulizadores;
sem_t sem_sala_espera;
pthread_mutex_t mutex; 
pthread_mutex_t mutex_pacientes_atendidos = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond_pacientes_atendidos = PTHREAD_COND_INITIALIZER;

int pacientes_atendidos = 0;
int pacientes_hospital = 0;
int pacientes_zero_vital = 0;

typedef struct {
    int id;
    int idade;
} Paciente;

Paciente sala_espera[MAX_PACIENTES];

int comparar_idades(const void *a, const void *b) {
    return ((Paciente *)a)->idade - ((Paciente *)b)->idade;
}

void *paciente(void *id) {
    int sinal_vital = 10;
    Paciente p;
    p.id = (int)(size_t)id;
    p.idade = rand() % 100; 

    sem_wait(&sem_sala_espera);

    if (pacientes_hospital < MAX_PACIENTES) {
        sala_espera[pacientes_hospital] = p;
        pacientes_hospital++;
        sem_post(&sem_sala_espera);

        while (sinal_vital > 0) {
            if (sem_trywait(&sem_nebulizadores) == 0) {
                sinal_vital += rand() % 3 + 2;
                sem_post(&sem_nebulizadores);
            } else {
                sinal_vital -= rand() % 2 + 1;
                if (sinal_vital == 0) {
                    pacientes_zero_vital++;
                }
            }
            sleep(1);
        }

        pthread_mutex_lock(&mutex);
        pacientes_atendidos++;
        pthread_mutex_unlock(&mutex);
    } else {
        sem_post(&sem_sala_espera);
    }

    pthread_exit(NULL);
}

void *medico(void *id) {
    while (1) {

        sem_wait(&sem_sala_espera);

        if (pacientes_atendidos < MAX_PACIENTES) {

            qsort(sala_espera, pacientes_hospital, sizeof(Paciente), comparar_idades);

            Paciente p = sala_espera[0];
            printf("Médico %d atendendo paciente %d com idade %d\n", (int)(size_t)id, p.id, p.idade);

            for (int i = 0; i < pacientes_hospital - 1; i++) {
                sala_espera[i] = sala_espera[i + 1];
            }
            pacientes_hospital--;

            pthread_mutex_lock(&mutex);
            pacientes_atendidos++;
            pthread_mutex_unlock(&mutex);

            sem_post(&sem_sala_espera);
        } else {
            sem_post(&sem_sala_espera);
            sleep(1); 
        }
    }

    pthread_exit(NULL);
}

int main() {
    pthread_t pacientes[MAX_PACIENTES];
    pthread_t medicos[NUM_MEDICOS];

    sem_init(&sem_medicos, 0, NUM_MEDICOS);
    sem_init(&sem_nebulizadores, 0, NUM_NEBULIZADORES);
    sem_init(&sem_sala_espera, 0, 1); // Inicialização com 1
    pthread_mutex_init(&mutex, NULL); // Inicialização do mutex

    for (int i = 0; i < NUM_MEDICOS; i++) {
        pthread_create(&medicos[i], NULL, medico, (void *)(size_t)i);
    }

    for (int i = 0; i < MAX_PACIENTES; i++) {
        pthread_create(&pacientes[i], NULL, paciente, (void *)(size_t)i);
        sleep(rand() % 3 + 1); // tempo entre chegadas de pacientes
    }

    // Aguarde todos os pacientes serem atendidos.
    pthread_mutex_lock(&mutex_pacientes_atendidos);
    while (pacientes_atendidos < MAX_PACIENTES) {
        pthread_cond_wait(&cond_pacientes_atendidos, &mutex_pacientes_atendidos);
    }
    pthread_mutex_unlock(&mutex_pacientes_atendidos);

    // Encerre os threads de médicos.
    for (int i = 0; i < NUM_MEDICOS; i++) {
        pthread_cancel(medicos[i]);
    }

    sem_destroy(&sem_medicos);
    sem_destroy(&sem_nebulizadores);
    sem_destroy(&sem_sala_espera);
    pthread_mutex_destroy(&mutex); // Destrua o mutex

    printf("Pacientes atendidos: %d\n", pacientes_atendidos);
    printf("Pacientes que foram ao hospital: %d\n", pacientes_hospital);
    printf("Pacientes com nível vital zero: %d\n", pacientes_zero_vital);

    return 0;
}
