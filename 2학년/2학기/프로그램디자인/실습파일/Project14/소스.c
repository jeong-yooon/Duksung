#include <stdio.h>
#include <stdlib.h>
#pragma warning (disable:4996)
#define ARRSIZE 256 //���ڿ��� ����
#define SIZE 3 //node�� ����
int main(void) {

    FILE* fp = NULL;
    char buffer[ARRSIZE];
    int menu = 0;
    int i = 0;
    int count1 = 0;
    int count2 = 0;
    int num = 0;
    fp = fopen("MYMusic.db", "a+");//MYmusic.db�� �б���� �߰����� fopen�Ѵ�
    if (fp == NULL) {
        fprintf(stderr, "���� MYMusic.db �� �� �� ����� \n");
        exit(1);
    }

    enum music_type { KPOP, POP, CLASSIC, SCRN_MUSIC }; //���� �帣

    typedef struct music {  //����ü music ����
        char title[ARRSIZE];
        char singer[ARRSIZE];
        enum music_type genre;
    } MUSIC;

    typedef struct node { //����ü node�� �����Ͽ� ����ü music�� data ������ ������ lint�� �����Ѵ�
        MUSIC data;
        struct node* link;
    }NODE;

    NODE* head;
    NODE* p;
    head = (NODE*)malloc(sizeof(NODE)); //malloc���� ������ head�� �޸� �Ҵ�
    p = head;

    for (i = 1; i < SIZE; i++) { //malloc���� linked-list ����
        p->link = (NODE*)malloc(sizeof(NODE));
        p = p->link;
    }
    p->link = NULL;


    printf("=================\n"); //����� �������̽�
    printf("1. ���� ���� �߰�\n");
    printf("2. ���� ���� ���\n");
    printf("3. ���� ���� �˻�\n");
    printf("4. ���α׷� ����\n");
    printf("=================\n");


    while (1)  //���α׷� ���� (4)�� ������ �ʴ� �̻� ���ѷ����� ���� ��
    {
        printf("�޴��� �����ϼ��� : ");

        scanf("%d", &menu);  //���� menu�� 1���� 4������ ���� ����

        if (menu == 1)
        {
            printf("���� ������ �߰��մϴ�.\n");
            printf("���� ���� : ");
            scanf("%s", &p[count1].data.title);
            printf("���� : ");
            scanf("%s", &p[count1].data.singer);
            printf("�帣( 1-����, 2-��, 3-Ŭ����, 4-��ȭost : ");
            scanf("%d", &p[count1].data.genre);

            fprintf(fp, "%s %s %d\n", p[count1].data.title, p[count1].data.singer, p[count1].data.genre);
            printf("�߰� �Ϸ�\n\n");
            count1++;
        }
        else if (menu == 2)
        {
            while (count2 < count1)
            {
                printf("���� ������ ����մϴ�.\n");
                printf("���� ���� : %s\n", &p[count2].data.title);
                printf("���� : %s\n", &p[count2].data.singer);
                printf("�帣 : %d\n", p[count2].data.genre);
                printf("======================\n");
                count2++;
            }
        }
        else if (menu == 3)
        {
            char singer[ARRSIZE];
            char title[ARRSIZE];

            printf("���� ������ �˻��մϴ�.\n");
            printf("1-���� �̸� �˻� / 2-���� ���� �˻� : ");
            scanf("%d", &num);

            switch (num)
            {
            case 1:

                printf("�����̸��� �Է��ϼ��� : ");
                scanf("%s", singer);

                for (i = 0; i < SIZE; i++)
                {

                    if (strcmp(&p[i].data.singer, singer) == 0)
                    {
                        printf("���� %s�� �뷡 �� %s �� ã�ҽ��ϴ�\n\n", singer, &p[i].data.title);
                    }
                }
                break;

            case 2:

                printf("�뷡 ������ �Է��ϼ��� : ");
                scanf("%s", title);

                for (i = 0; i < SIZE; i++) {

                    if (strcmp(&p[i].data.title, title) == 0)
                    {
                        printf("�뷡 %s�� ���� %s�� ã�ҽ��ϴ�\n\n", title, &p[i].data.singer);
                    }
                }
                break;

            default: printf("�߸� �Է��߽��ϴ�\n");
                break;
            }
        }
        else
        {
            printf("���α׷��� �����մϴ�.\n");
            exit(1);
        }
    }

    free(p);
    fclose(fp);
    return 0;
}