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

void Selection_sort(int *list[], int n) // �ε��� ������� �ּҰ� ����
{
	int i, j, temp, least;
	for (i = 0; i < n - 1; i++)
	{
		least = i;
		for (j = i + 1; j < n; j++) // �ּҰ� Ž��
			if (list[j] < list[least])
				least = j;
		// i��° ���ҿ� least ��ġ�� ���Ҹ� ��ȯ
		temp = list[i];
		list[i] = list[least];
		list[least] = temp;
	}
}


void Insertion_sort(int *a[], int n) {
	int wall, j, pivot = 0;
	for (wall = 1; wall < n; wall++) {
		pivot = a[wall]; // wall �̸� = sorted portion
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
	// ��ĵ ȸ���� �����ϱ� ���� ����
	for (scan = 0; scan < n - 1; scan++)
	{
		// ������ �� ȸ���� �����ϱ� ���� ����
		for (i = 0; i < n - 1; i++)
		{
			// ������ �� �� ��ȯ
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
	// ������ �迭 ���
	printf("������ �迭\n");
	print_array(&sortData, SIZE);
	printf("\n");
	Selection_sort(&sortData, SIZE);	//�� �κ��� �����Ͽ� ���Ĺ���� �ٲ۴�
	//Insertion_sort(&sortData, SIZE);
	//Bubble_sort(&sortData, SIZE);
	 //���ĵ� �迭 ���
	printf("���ĵ� �迭\n");
	print_array(&sortData, SIZE);

	return 0;
}