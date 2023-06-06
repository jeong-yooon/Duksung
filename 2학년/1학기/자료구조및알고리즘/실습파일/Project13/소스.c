#include<stdio.h>
#define ELEMENT 20
#define ROW 4 //행의 갯수
#define COL 5 //열의 갯수

void DimensionOne(void) {
	int arr[ELEMENT];
	int i, j;

	//배열 초기화
	for (i = 0; i < ELEMENT; i++) {
		arr[i] = i + 1;
	}

	//1-1. 행 우선적으로 출력
	int a = 0;
	printf("1차원 배열 행 우선 출력 \n");
	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			printf("%d ", arr[a]);
			a++;
		}
		printf("\n");
	}
	printf("\n\n");

	//1-2. 열 우선적으로 출력
	int b = 0;
	printf("1차원 배열 열 우선 출력 \n");
	for (j = 0; j < COL; j++) {
		for (i = 0; i < ROW; i++) {
			printf("%d ", arr[b]);
			b = b + COL;
		}
		b = j + 1;
		printf("\n");
	}
	printf("\n\n");
}

void DimensionTwo(void) {
	int arr[ROW][COL];
	int i, j = 0;

	//배열초기화
	int temp = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				arr[i][j] = temp + 1;
				temp++;
			}
		}

	//2-1. 행 우선적으로 출력
	printf("2차원 배열 행 우선 출력 \n");
	for (int i = 0; i < ROW; i++) {
		for (int j = 0; j < COL; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}

	printf("\n\n");

	//2-2. 열 우선적으로 출력
	printf("2차원 배열 열 우선 출력 \n");
	for (int j = 0; j < COL; j++) {
		for (int i = 0; i < ROW; i++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}

	printf("\n\n");
}

int main(void) {
	
	DimensionOne();
	DimensionTwo();

	return 0;
}