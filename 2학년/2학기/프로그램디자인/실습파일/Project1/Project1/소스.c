#include <stdio.h>
#pragma warning (disable:4996)

int sum(int n) {

	if (n == 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 1;
	if (n == 3) return 2;

	else
	return sum(n-1) + sum(n-2) + sum(n-3);
}

int main(void) {

	int N = 0;
	scanf("%d", &N);
	printf("%d", sum(N));
	return 0;
}