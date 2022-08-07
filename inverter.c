/*34 - Faça uma função recursiva que permita inverter um número inteiro N. Ex: 123 – 321*/
#include <stdio.h>

int numero;
int aux;

int invert(int n){
    if(n==0)
      return n;
     else{
     printf("%d", n % 10);
     n=n / 10;
     return invert(n);
    }
return 0;
 }
int main(){
   printf("Digite um numero:");
   scanf("%d",&numero);
   invert(numero);
   return 0;
}