#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#pragma warning(disable:4996)
#define SIZE 100


void print_array(int *list[], int n)
{
	int i;
	for (i = 0; i < n; i++)
		printf("%d ", list[i]);
	printf("\n");
}

void Selection_sort(int *list[], int n) // 인덱스 기반으로 최소값 선택
{
	int i, j, temp, least;
	for (i = 0; i < n - 1; i++)
	{
		least = i;
		for (j = i + 1; j < n; j++) // 최소값 탐색
			if (list[j] < list[least])
				least = j;
		// i번째 원소와 least 위치의 원소를 교환
		temp = list[i];
		list[i] = list[least];
		list[least] = temp;
	}
}


void Insertion_sort(int *a[], int n) {
	int wall, j, pivot = 0;
	for (wall = 1; wall < n; wall++) {
		pivot = a[wall]; // wall 미만 = sorted portion
		j = wall - 1;
		while (j >= 0 && (pivot < a[j])) {
			a[j + 1] = a[j];
			j--;
		}
		a[j + 1] = pivot;
	}
}

void Bubble_sort(int *a[], int n)
{
	int i, scan, temp;
	// 스캔 회수를 제어하기 위한 루프
	for (scan = 0; scan < n - 1; scan++)
	{
		// 인접값 비교 회수를 제어하기 위한 루프
		for (i = 0; i < n - 1; i++)
		{
			// 인접값 비교 및 교환
			if (a[i] > a[i + 1])
			{
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
	}
}

int main(void) {

	int i = 0;
	int sortData[SIZE];

	for ( i = 0; i < 100; i++) {
		sortData[i] = rand();
	}
	// 원래의 배열 출력
	printf("원래의 배열\n");
	print_array(&sortData, SIZE);
	printf("\n");
	Selection_sort(&sortData, SIZE);	//이 부분을 수정하여 정렬방식을 바꾼다
	//Insertion_sort(&sortData, SIZE);
	//Bubble_sort(&sortData, SIZE);
	 //정렬된 배열 출력
	printf("정렬된 배열\n");
	print_array(&sortData, SIZE);

	return 0;
}