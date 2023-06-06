#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#ifdef _MSC_VER
#pragma warning (disable:4996)
#endif
/*
int convert_string(const void* a, const void* b)
{
    return strcmp((char*)a, (char*)b);
}
*/
int main(void) {

    int i, j;
    int n = 0;
    scanf("%d", &n);
    char* arr;
    arr = (char**)malloc(n  * sizeof(char*));
    for (i = 0; i < n; i++) {
        arr[i] = (char*)malloc(n ^ 2 * sizeof(char));
    }
    for (j = 0; j < n; j++) {
        arr[j] = (char*)malloc(n * sizeof(char));
    }
   // qsort(arr, sizeof(arr) / sizeof(arr[0]), sizeof(arr[0]), convert_string);
    for (i = 0; i < 2 ^ n; i++) {
        for (j = 0; j < n; j++) {
            arr[i][j];

        }
    }
    return 0;
}