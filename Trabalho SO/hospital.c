#include <pthread.h>
#include <semaphore.h>
#include <stdlib.h>
#include <unistd.h>

#define MAX_PACIENTES 16
#define NUM_MEDICOS 2
#define NUM_NEBULIZADORES 4

sem_t sem_medicos;
sem_t sem_nebulizadores;
sem_t sem_sala_espera;

int pacientes_atendidos = 0;
int pacientes_hospital = 0;
int pacientes_zero_vital = 0;

void *paciente(void *id) {
    int sinal_vital = 10;

    if (sem_trywait(&sem_sala_espera) == 0) {
        pacientes_hospital++;
        while (sinal_vital > 0) {
            if (sem_trywait(&sem_nebulizadores) == 0) {
                sinal_vital += rand() % 3 + 2; // aumenta o sinal vital
                sem_post(&sem_nebulizadores);
            } else {
                sinal_vital -= rand() % 2 + 1; // diminui o sinal vital
                if (sinal_vital == 0) {
                    pacientes_zero_vital++;
                }
            }
            sleep(1);
        }
        sem_post(&sem_sala_espera);
    }

    pthread_exit(NULL);
}

void *medico(void *id) {
    while (1) {
        if (sem_trywait(&sem_sala_espera) == 0) {
            sleep(rand() % 3 + 1); // tempo de atendimento
            pacientes_atendidos++;
            sem_post(&sem_sala_espera);
        }
        sleep(1);
    }

    pthread_exit(NULL);
}

int main() {
    pthread_t pacientes[MAX_PACIENTES];
    pthread_t medicos[NUM_MEDICOS];

    sem_init(&sem_medicos, 0, NUM_MEDICOS);
    sem_init(&sem_nebulizadores, 0, NUM_NEBULIZADORES);
    sem_init(&sem_sala_espera, 0, MAX_PACIENTES);

    for (int i = 0; i < NUM_MEDICOS; i++) {
        pthread_create(&medicos[i], NULL, medico, (void *)(size_t)i);
    }

    for (int i = 0; i < MAX_PACIENTES; i++) {
        pthread_create(&pacientes[i], NULL, paciente, (void *)(size_t)i);
        sleep(rand() % 3 + 1); // tempo entre chegadas de pacientes
    }

    for (int i = 0; i < MAX_PACIENTES; i++) {
        pthread_join(pacientes[i], NULL);
    }

    printf("Pacientes atendidos: %d\n", pacientes_atendidos);
    printf("Pacientes que foram ao hospital: %d\n", pacientes_hospital);
    printf("Pacientes com nível vital zero: %d\n", pacientes_zero_vital);

    return 0;
}
