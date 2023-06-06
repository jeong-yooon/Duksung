#include <stdio.h>
#include <search.h>
#include <string.h>
#include <stdlib.h>
#pragma warning(disable:4996)
#define SIZE 100

int binary_search(int *list[], int key, int low, int high) {
	if (high < low)
		return -1; // not found
	int mid = (low + high) / 2;
	if (list[mid] > key)
		return binary_search(list, key, low, mid - 1);
	else if (list[mid] < key)
		return binary_search(list, key, mid + 1, high);
	else
		return mid; // found
}

void main(void) {
	// qsort 라이브러리를 사용
	int i, key = 0;
	int sort[SIZE];

	printf("0~99사이의 값을 입력하시오.");
	scanf("%d", &key);
	for (i = 0; i < 100; i++) {
		sort[i] = rand()%100;
	}
	qsort(&sort, SIZE, sizeof(int), strcmp);
	for (i = 0; i < SIZE; i++)
		printf("%d ", sort[i]);
	printf("\n");
	int result = binary_search(&sort, key, 0, SIZE);
	printf("%d", result);

	return 0;
}