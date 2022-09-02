#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void *adicionaPessoa(void *pBuffer);
void removePessoa(void *pBuffer);
void buscaPessoa(void *pFuffer);
void listaPessoa(void *pBuffer);

int main(){
    int opcao;

    void *pBuffer = malloc(sizeof(int));

    if (pBuffer == NULL){
        printf("Erro ao alocar memória.\n");
        exit(1);
    }

    do{
        printf("------------------------\n");
        printf("\tEscolha uma opção: \n");
        printf("\t1)Adicionar pessoa \n");
        printf("\t2)Remover pessoa \n");
        printf("\t3)Buscar pessoa \n");
        printf("\t4)Listar \n");
        printf("\t5)Sair \n");
        printf("------------------------\n");
        scanf("%i", &opcao);

        switch (opcao)
        {
        case 1:
            pBuffer = adicionaPessoa(pBuffer);
            break;
        case 2:
            removePessoa(pBuffer);
            break;
        case 3:
            buscaPessoa(pBuffer);
            break;
        case 4:
            listaPessoa(pBuffer);
            break;
        
        case 5:
            system("pause");
        
        default:
            printf("Digite um numero valido!");
            break;
        }

    } while (opcao != 5);
}

/*
 *Essa função tem como objetivo adicionar os dados de uma pessoa e alocar o espaço
 *no buffer pBuffer.
 */

void *adicionaPessoa(void *pBuffer){
    pBuffer = (void *)realloc(pBuffer, sizeof(int) * 1 + sizeof(char) * 30 + sizeof(int) * 2) * (*((int *)(pBuffer))+ 1);

    printf("Declare os dados que deseja armazenar: \n");
    printf("Nome: \n");
    scanf("%s", (char *)(pBuffer, sizeof(int) * 1 + sizeof(char) * 30 + sizeof(int) * 2) * (*((int *)(pBuffer))));
    printf("Idade: \n");
    scanf("%i", (int *)(pBuffer, sizeof(int) * 1 + sizeof(char) * 30 + sizeof(int) * 2) * (*((int *)(pBuffer))));
    printf("Telefone: \n");
    scanf("%i", (int *)(pBuffer, sizeof(int) * 1 + sizeof(char) * 30 + sizeof(int) * 2) * (*((int *)(pBuffer))));
    
    *(int *)(pBuffer) += 1;

    return pBuffer;
}