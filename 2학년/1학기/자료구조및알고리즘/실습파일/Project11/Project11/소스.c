#include <stdio.h>
#include <math.h>
#pragma warning(disable:4996)

struct point {
    int x, y;
};
struct line {
    struct point start;
    struct point end;
};
int main(void)
{
    struct line ln;
    double length;

    printf("���� �������� ��ǥ�� �Է��ϼ��� : ");
    scanf("%d %d", &ln.start.x, &ln.start.y);
    printf("���� ������ ��ǥ�� �Է��ϼ��� : ");
    scanf("%d %d", &ln.end.x, &ln.end.y);
    length = sqrt(pow(ln.end.x - ln.start.x, 2) + pow(ln.end.y - ln.start.y, 2));
    printf("���� ���� : %lf\n", length);
    return 0;
}