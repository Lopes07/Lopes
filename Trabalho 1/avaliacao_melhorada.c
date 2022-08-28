//Lucas Lopes Silva, Turma M1
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int inteiro;
    float floatF;
    double doubleD;
} Valor;

void *adicionaInt( Valor *ponteiroValor, int tamanhoLista );
void *adicionaFloat( Valor *ponteiroValor, int tamanhoLista );
void *adicionaDouble( Valor *ponteiroValor, int tamanhoLista );
void imprimir( Valor *ponteiroValor, int tamanhoLista );

int main(){
    
    int tamanhoLista = 0;
    Valor *ponteiroValor = NULL;

    int tipo = 0;


    do {
        printf("\nDeclare o tipo de dado que deseja armazenar: \n");
        printf("\t1) Adicionar inteiro: \n");
        printf("\t2) Adicionar float: \n");
        printf("\t3) Adicionar double: \n");
        printf("\t4) Sair \n");
        scanf("%i", &tipo);
        getchar();

        switch ( tipo )
        {
        case 1:
            ponteiroValor = adicionaInt( ponteiroValor, tamanhoLista );
            tamanhoLista++;
            break;

        case 2:
            ponteiroValor = adicionaFloat( ponteiroValor, tamanhoLista );
            tamanhoLista++;
            break;

        case 3:
            ponteiroValor = adicionaDouble( ponteiroValor, tamanhoLista );
            tamanhoLista++;
            break;

        case 4:
            imprimir( ponteiroValor, tamanhoLista );
            break;
            
        default:
            printf("Digite um tipo válido.\n ");
            break;
        }
    } while((tipo >= 1) || (tipo <= 4));

    return 0;
}

/*
 *Essa função tem como objetivo receber um inteiro do usuário e armazená-la 
 *na região específica da struct reservada aos inteiros.    
 */
void *adicionaInt( Valor *ponteiroValor, int tamanhoLista){
    if ( tamanhoLista != 0 ){ //nao é o primeiro valor
        ponteiroValor = realloc(ponteiroValor, sizeof(Valor) + sizeof(int));
    } else { //é o primeiro valor
        ponteiroValor = malloc(sizeof(int));
    }

    printf("\nDigite o inteiro que deseja armazenar: ");
    scanf("%i", (ponteiroValor + tamanhoLista) -> inteiro);
    getchar();
}

/*
 *Essa função tem como objetivo receber um float do usuário e armazená-la 
 *na região específica da struct reservada aos floats.    
 */
void *adicionaFloat( Valor *ponteiroValor, int tamanhoLista){
    if ( tamanhoLista != 0 ){ //nao é o primeiro valor
        ponteiroValor = realloc(ponteiroValor, sizeof(Valor) + sizeof(float));
    } else { //é o primeiro valor
        ponteiroValor = malloc(sizeof(float));
    }

    printf("\nDigite o float que deseja armazenar: ");
    scanf("%f", (ponteiroValor + tamanhoLista) -> floatF);
    getchar();
}

/*
 *Essa função tem como objetivo receber um double do usuário e armazená-la 
 *na região específica da struct reservada aos doubles.    
 */
void *adicionaDouble( Valor *ponteiroValor, int tamanhoLista){
    if ( tamanhoLista != 0 ){ //nao é o primeiro valor
        ponteiroValor = realloc(ponteiroValor, sizeof(Valor) + sizeof(double));
    } else { //é o primeiro valor
        ponteiroValor = malloc(sizeof(double));
    }

    printf("\nDigite o double que deseja armazenar: ");
    scanf("%lf", (ponteiroValor + tamanhoLista) -> doubleD);
    getchar();
}

/*
 *Essa função tem como objetivo imprimir todo o buffer
 */
void imprimir(Valor *ponteiroValor, int tamanhoLista){
    if ( tamanhoLista > 0 ){
        for( int i = 0; i < tamanhoLista; i++ ){
            printf("%i\n", ( ponteiroValor + i ) -> inteiro );
            printf("%.2f\n", ( ponteiroValor + i ) -> floatF );
            printf("%lf\n", ( ponteiroValor + i) -> doubleD );
        }
    } else {
        printf("\nNão foi inserido nenhum número.\n");
    }
    
}
