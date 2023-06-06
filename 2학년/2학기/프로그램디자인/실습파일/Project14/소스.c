#include <stdio.h>
#include <stdlib.h>
#pragma warning (disable:4996)
#define ARRSIZE 256 //문자열의 길이
#define SIZE 3 //node의 개수
int main(void) {

    FILE* fp = NULL;
    char buffer[ARRSIZE];
    int menu = 0;
    int i = 0;
    int count1 = 0;
    int count2 = 0;
    int num = 0;
    fp = fopen("MYMusic.db", "a+");//MYmusic.db를 읽기모드와 추가모드로 fopen한다
    if (fp == NULL) {
        fprintf(stderr, "파일 MYMusic.db 를 열 수 없어요 \n");
        exit(1);
    }

    enum music_type { KPOP, POP, CLASSIC, SCRN_MUSIC }; //음악 장르

    typedef struct music {  //구조체 music 선언
        char title[ARRSIZE];
        char singer[ARRSIZE];
        enum music_type genre;
    } MUSIC;

    typedef struct node { //구조체 node를 선언하여 구조체 music의 data 변수와 포인터 lint를 포함한다
        MUSIC data;
        struct node* link;
    }NODE;

    NODE* head;
    NODE* p;
    head = (NODE*)malloc(sizeof(NODE)); //malloc으로 포인터 head에 메모리 할당
    p = head;

    for (i = 1; i < SIZE; i++) { //malloc으로 linked-list 생성
        p->link = (NODE*)malloc(sizeof(NODE));
        p = p->link;
    }
    p->link = NULL;


    printf("=================\n"); //사용자 인터페이스
    printf("1. 음악 정보 추가\n");
    printf("2. 음악 정보 출력\n");
    printf("3. 음악 정보 검색\n");
    printf("4. 프로그램 종료\n");
    printf("=================\n");


    while (1)  //프로그램 종료 (4)를 누르지 않는 이상 무한루프를 돌게 함
    {
        printf("메뉴를 선택하세요 : ");

        scanf("%d", &menu);  //정수 menu를 1부터 4까지의 수로 저장

        if (menu == 1)
        {
            printf("음악 정보를 추가합니다.\n");
            printf("음악 제목 : ");
            scanf("%s", &p[count1].data.title);
            printf("가수 : ");
            scanf("%s", &p[count1].data.singer);
            printf("장르( 1-가요, 2-팝, 3-클래식, 4-영화ost : ");
            scanf("%d", &p[count1].data.genre);

            fprintf(fp, "%s %s %d\n", p[count1].data.title, p[count1].data.singer, p[count1].data.genre);
            printf("추가 완료\n\n");
            count1++;
        }
        else if (menu == 2)
        {
            while (count2 < count1)
            {
                printf("음악 정보를 출력합니다.\n");
                printf("음악 제목 : %s\n", &p[count2].data.title);
                printf("가수 : %s\n", &p[count2].data.singer);
                printf("장르 : %d\n", p[count2].data.genre);
                printf("======================\n");
                count2++;
            }
        }
        else if (menu == 3)
        {
            char singer[ARRSIZE];
            char title[ARRSIZE];

            printf("음악 정보를 검색합니다.\n");
            printf("1-가수 이름 검색 / 2-음악 제목 검색 : ");
            scanf("%d", &num);

            switch (num)
            {
            case 1:

                printf("가수이름을 입력하세요 : ");
                scanf("%s", singer);

                for (i = 0; i < SIZE; i++)
                {

                    if (strcmp(&p[i].data.singer, singer) == 0)
                    {
                        printf("가수 %s의 노래 중 %s 를 찾았습니다\n\n", singer, &p[i].data.title);
                    }
                }
                break;

            case 2:

                printf("노래 제목을 입력하세요 : ");
                scanf("%s", title);

                for (i = 0; i < SIZE; i++) {

                    if (strcmp(&p[i].data.title, title) == 0)
                    {
                        printf("노래 %s의 가수 %s를 찾았습니다\n\n", title, &p[i].data.singer);
                    }
                }
                break;

            default: printf("잘못 입력했습니다\n");
                break;
            }
        }
        else
        {
            printf("프로그램을 종료합니다.\n");
            exit(1);
        }
    }

    free(p);
    fclose(fp);
    return 0;
}