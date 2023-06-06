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

    printf("선의 시작점의 좌표를 입력하세요 : ");
    scanf("%d %d", &ln.start.x, &ln.start.y);
    printf("선의 끝점의 좌표를 입력하세요 : ");
    scanf("%d %d", &ln.end.x, &ln.end.y);
    length = sqrt(pow(ln.end.x - ln.start.x, 2) + pow(ln.end.y - ln.start.y, 2));
    printf("선의 길이 : %lf\n", length);
    return 0;
}