#include <Windows.h>
#include<stdio.h>
#include<GL/GLUT.H>
#include<GL/GL.H>
#include<GL/GLU.H>
#pragma warning (disable:4996)

//꼭지점정보 . 삼각형정보를 저장할 배열 변수 선언.
int numV1, numV2, numV3; //꼭짓점 개수, 파일에서 읽어 와야 함. 여기에서는 17668
int numT1, numT2, numT3; //삼각형 개수, 파일에서 읽어 와야 함. 여기에서는 16922

float* vx1;
float* vy1;
float* vz1;

float* vx2;
float* vy2;
float* vz2;

float* vx3;
float* vy3;
float* vz3;

int* a1;
int* b1;
int* c1;

int* a2;
int* b2;
int* c2;

int* a3;
int* b3;
int* c3;

int* R1;
int* G1;
int* B1;
int* alpha1;

int* R2;
int* G2;
int* B2;
int* alpha2;

int* R3;
int* G3;
int* B3;
int* alpha3;

float vx_max1 = -100000.0f;
float vy_max1 = -100000.0f;
float vz_max1 = -100000.0f;

float vx_min1 = 100000.0f;
float vy_min1 = 100000.0f;
float vz_min1 = 100000.0f;

float vx_max2 = -100000.0f;
float vy_max2 = -100000.0f;
float vz_max2 = -100000.0f;

float vx_min2 = 100000.0f;
float vy_min2 = 100000.0f;
float vz_min2 = 100000.0f;

float vx_max3 = -100000.0f;
float vy_max3 = -100000.0f;
float vz_max3 = -100000.0f;

float vx_min3 = 100000.0f;
float vy_min3 = 100000.0f;
float vz_min3 = 100000.0f;

float lmax1, lmax2, lmax3;
int menu;

GLfloat w, h, tx1, ty1, tx2, ty2, tx3, ty3, sx, sy, sz;

static int Sup = 0, Sdown = 0, Mx = 0, Px = 0, My = 0, Py = 0, Mz = 0, Pz = 0;
static char array[20];

void reshape(int w, int h) {

	glLoadIdentity();
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	// 카메라 설정

	glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
	//glFrustum(-1.0, 1.0, -1.0, 1.0, -1.0f, 1.0f);
	//gluPerspective(60.0, w/h, 1.0f, 30.0f);

}

void display(void) {

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glMatrixMode(GL_MODELVIEW);
	gluLookAt(0.0f, 0.0f, 0.3f, -(vx_max3 + vx_min3) / 2.0f, -(vy_max3 + vy_min3) / 2.0f, -(vz_max3 + vz_min3) / 2.0f, 0.0f, 1.0f, 0.0f); // 카메라 위치 정보
	
	glLoadIdentity();
	glPushMatrix();

	// rotate 정보

	glRotatef((float)Mx, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)My, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Mz, 1.0f, 0.0f, 0.0f); //z축
	glRotatef((float)Px, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)Py, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Pz, 1.0f, 0.0f, 0.0f); //z축

	// scale 정보

	glScalef(1.0f / lmax3 + (float)sx, 1.0f / lmax3 + (float)sy, 1.0f / lmax3 + (float)sz);

	// translate 정보

	glTranslatef(-(vx_max3 + vx_min3) / 2.0f + (float)tx1 - 15.0f, -(vy_max3 + vy_min3) / 2.0f + (float)ty1, -(vz_max3 + vz_min3) / 2.0f); // 중심점


	//모델배치
		
		glBegin(GL_TRIANGLES);
		for (int i = 0; i < numT1; i++) {
			glColor3f(R1[a1[i]] / 255.0, G1[a1[i]] / 255.0, B1[a1[i]] / 255.0);
			glVertex3f(vx1[a1[i]], vy1[a1[i]], vz1[a1[i]]);
			glColor3f(R1[b1[i]] / 255.0, G1[b1[i]] / 255.0, B1[b1[i]] / 255.0);
			glVertex3f(vx1[b1[i]], vy1[b1[i]], vz1[b1[i]]);
			glColor3f(R1[c1[i]] / 255.0, G1[c1[i]] / 255.0, B1[c1[i]] / 255.0);
			glVertex3f(vx1[c1[i]], vy1[c1[i]], vz1[c1[i]]);
		}
		glEnd();

	glPopMatrix();

	glLoadIdentity();
	glPushMatrix();

	// rotate 정보

	glRotatef((float)Mx, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)My, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Mz, 1.0f, 0.0f, 0.0f); //z축
	glRotatef((float)Px, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)Py, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Pz, 1.0f, 0.0f, 0.0f); //z축

	// scale 정보

	glScalef(1.0f / lmax3 + (float)sx, 1.0f / lmax3 + (float)sy, 1.0f / lmax3 + (float)sz);

	// translate 정보

	glTranslatef(-(vx_max3 + vx_min3) / 2.0f + (float)tx2, -(vy_max3 + vy_min3) / 2.0f + (float)ty2, -(vz_max3 + vz_min3) / 2.0f); // 중심점


	//모델배치


	glBegin(GL_TRIANGLES);
	for (int i = 0; i < numT2; i++) {
		glColor3f(R2[a2[i]] / 255.0, G2[a2[i]] / 255.0, B2[a2[i]] / 255.0);
		glVertex3f(vx2[a2[i]], vy2[a2[i]], vz2[a2[i]]);
		glColor3f(R2[b2[i]] / 255.0, G2[b2[i]] / 255.0, B2[b2[i]] / 255.0);
		glVertex3f(vx2[b2[i]], vy2[b2[i]], vz2[b2[i]]);
		glColor3f(R2[c2[i]] / 255.0, G2[c2[i]] / 255.0, B2[c2[i]] / 255.0);
		glVertex3f(vx2[c2[i]], vy2[c2[i]], vz2[c2[i]]);
	}
	glEnd();


	glPopMatrix();

	glLoadIdentity();
	glPushMatrix();

	// rotate 정보

	glRotatef((float)Mx, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)My, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Mz, 1.0f, 0.0f, 0.0f); //z축
	glRotatef((float)Px, 0.0f, 0.0f, 1.0f); //x축
	glRotatef((float)Py, 0.0f, 1.0f, 0.0f); //y축
	glRotatef((float)Pz, 1.0f, 0.0f, 0.0f); //z축

	// scale 정보

	glScalef(1.0f / lmax3 + (float)sx, 1.0f / lmax3 + (float)sy, 1.0f / lmax3 + (float)sz);

	// translate 정보

	glTranslatef(-(vx_max3 + vx_min3) / 2.0f + (float)tx3, -(vy_max3 + vy_min3) / 2.0f + (float)ty3, -(vz_max3 + vz_min3) / 2.0f); // 중심점


	//모델배치


	glBegin(GL_TRIANGLES);
	for (int i = 0; i < numT3; i++) {
		glColor3f(R3[a3[i]] / 255.0, G3[a3[i]] / 255.0, B3[a3[i]] / 255.0);
		glVertex3f(vx3[a3[i]], vy3[a3[i]], vz3[a3[i]]);
		glColor3f(R3[b3[i]] / 255.0, G3[b3[i]] / 255.0, B3[b3[i]] / 255.0);
		glVertex3f(vx3[b3[i]], vy3[b3[i]], vz3[b3[i]]);
		glColor3f(R3[c3[i]] / 255.0, G3[c3[i]] / 255.0, B3[c3[i]] / 255.0);
		glVertex3f(vx3[c3[i]], vy3[c3[i]], vz3[c3[i]]);
	}
	glEnd();

	glPopMatrix();

	glFlush();
	glutSwapBuffers();

}

void keyboard(unsigned char key, int x, int y) {

	switch (key) {


	case 'w': // cat up
		ty1 = ty1 + 10.0f;
		glutPostRedisplay();
		break;
	case 's': // cat down
		ty1 = ty1 - 10.0f;
		glutPostRedisplay();
		break;
	case 'a': // cat left
		tx1 = tx1 - 10.0f;
		glutPostRedisplay();
		break;
	case 'd': // cat right
		tx1 = tx1 + 10.0f;
		glutPostRedisplay();
		break;
	case 'i': // tent up
		ty2 = ty2 + 10.0f;
		glutPostRedisplay();
		break;
	case 'k': // tent down
		ty2 = ty2 - 10.0f;
		glutPostRedisplay();
		break;
	case 'j': // tent left
		tx2 = tx2 - 10.0f;
		glutPostRedisplay();
		break;
	case 'l': // tent right
		tx2 = tx2 + 10.0f;
		glutPostRedisplay();
		break;
	case 'z': // bag up
		ty3 = ty3 + 10.0f;
		glutPostRedisplay();
		break;
	case 'x': // bag down
		ty3 = ty3 - 10.0f;
		glutPostRedisplay();
		break;
	case 'c': // bag left
		tx3 = tx3 - 10.0f;
		glutPostRedisplay();
		break;
	case 'v': // bag right
		tx3 = tx3 + 10.0f;
		glutPostRedisplay();
		break;
	case '+': // scale up
		sx = sx + 0.01f;
		sy = sy + 0.01f;
		sz = sz + 0.01f;
		glutPostRedisplay();
		break;
	case '-': // scale down
		sx = sx - 0.01f;
		sy = sy - 0.01f;
		sz = sz - 0.01f;
		glutPostRedisplay();
		break;
	case 'y': // -x
		Mx = (Mx - 10) % 360;
		glutPostRedisplay();
		break;
	case 'b': // +x
		Px = (Px + 10) % 360;
		glutPostRedisplay();
		break;
	case 'g': // -y
		My = (My - 10) % 360;
		glutPostRedisplay();
		break;
	case 'h': // +y
		Py = (Py + 10) % 360;
		glutPostRedisplay();
		break;
	case 'n': // -z
		Mz = (Mz - 10) % 360;
		glutPostRedisplay();
		break;
	case 'm': // +z
		Pz = (Pz + 10) % 360;
		glutPostRedisplay();
		break;
	default:
		break;
	}
}

int main(int argc, char** argv) {

	//1. off 파일에서 꼭지점 개수와 삼각형 개수 읽어 온다.
	char str[255];
	int dummy;

	FILE* fp1 = fopen("C:\\what_is_this\\color_cat.off", "r");
	FILE* fp2 = fopen("C:\\what_is_this\\color_tent.off", "r");
	FILE* fp3 = fopen("C:\\what_is_this\\color_bag.off", "r");
	/*---------------------------------------     fp1     -------------------------------------------*/
	fscanf(fp1, "%s", str); //첫줄(OFF) 읽고 버리기
	fscanf(fp1, "%d %d %d", &numV1, &numT1, &dummy); //두번째 줄에서 꼭지점 개수, 삼각형 개수, 의미 없는 정보 읽기

	//2. 꼭지점 개수와 삼각형 개수만큼 배열로 메모리 할당
	vx1 = new float[numV1];
	vy1 = new float[numV1];
	vz1 = new float[numV1];

	a1 = new int[numT1];
	b1 = new int[numT1];
	c1 = new int[numT1];

	R1 = new int[numV1];
	G1 = new int[numV1];
	B1 = new int[numV1];
	alpha1 = new int[numV1];

	//3. off파일에서 vertex좌표와 삼각형 정보를 읽어서 전역변수의 배열에 정보 채우기
	//꼭지점 배열 채우기
	int i;

	for (i = 0; i < numV1; i++) {
		fscanf(fp1, "%f %f %f %d %d %d %d", &vx1[i], &vy1[i], &vz1[i], &R1[i], &G1[i], &B1[i], &alpha1[i]);

		//x,y,z 축 방향으로 꼭지점의 최대 최소값 결정 (바운딩 박스를 잡을 때 사용)
		//원점에서 가장 가까운꼭지점이 min 가장 먼꼭지점이 max
		if (vx1[i] > vx_max1)
			vx_max1 = vx1[i];

		if (vx1[i] < vx_min1)
			vx_min1 = vx1[i];

		if (vy1[i] > vy_max1)
			vy_max1 = vy1[i];

		if (vy1[i] < vy_min1)
			vy_min1 = vy1[i];

		if (vz1[i] > vz_max1)
			vz_max1 = vz1[i];

		if (vz1[i] < vz_min1)
			vz_min1 = vz1[i];
	}

	//삼각형 색인 배열 채우기(a, b, c)
	for (i = 0; i < numT1; i++) {
		fscanf(fp1, "%d %d %d %d %d %d %d", &dummy, &a1[i], &b1[i], &c1[i], &dummy, &dummy, &dummy);
	}
	lmax1 = max(max(vx_max1 - vx_min1, vy_max1 - vy_min1), vz_max1 - vz_min1); //셋 중 가장 큰 값 찾기

	/*---------------------------------------     fp2     -------------------------------------------*/
	fscanf(fp2, "%s", str); //첫줄(OFF) 읽고 버리기
	fscanf(fp2, "%d %d %d", &numV2, &numT2, &dummy); //두번째 줄에서 꼭지점 개수, 삼각형 개수, 의미 없는 정보 읽기

	//2. 꼭지점 개수와 삼각형 개수만큼 배열로 메모리 할당
	vx2 = new float[numV2];
	vy2 = new float[numV2];
	vz2 = new float[numV2];

	a2 = new int[numT2];
	b2 = new int[numT2];
	c2 = new int[numT2];

	R2 = new int[numV2];
	G2 = new int[numV2];
	B2 = new int[numV2];
	alpha2 = new int[numV2];

	//3. off파일에서 vertex좌표와 삼각형 정보를 읽어서 전역변수의 배열에 정보 채우기
	//꼭지점 배열 채우기

	for (i = 0; i < numV2; i++) {
		fscanf(fp2, "%f %f %f %d %d %d %d", &vx2[i], &vy2[i], &vz2[i], &R2[i], &G2[i], &B2[i], &alpha2[i]);

		//x,y,z 축 방향으로 꼭지점의 최대 최소값 결정 (바운딩 박스를 잡을 때 사용)
		//원점에서 가장 가까운꼭지점이 min 가장 먼꼭지점이 max
		if (vx2[i] > vx_max2)
			vx_max2 = vx2[i];

		if (vx2[i] < vx_min2)
			vx_min2 = vx2[i];

		if (vy2[i] > vy_max2)
			vy_max2 = vy2[i];

		if (vy2[i] < vy_min2)
			vy_min2 = vy2[i];

		if (vz2[i] > vz_max2)
			vz_max2 = vz2[i];

		if (vz2[i] < vz_min2)
			vz_min2 = vz2[i];
	}

	//삼각형 색인 배열 채우기(a, b, c)
	for (i = 0; i < numT2; i++) {
		fscanf(fp2, "%d %d %d %d %d %d %d", &dummy, &a2[i], &b2[i], &c2[i], &dummy, &dummy, &dummy);
	}
	lmax2 = max(max(vx_max2 - vx_min2, vy_max2 - vy_min2), vz_max2 - vz_min2); //셋 중 가장 큰 값 찾기

	/*---------------------------------------     fp3     -------------------------------------------*/
	fscanf(fp3, "%s", str); //첫줄(OFF) 읽고 버리기
	fscanf(fp3, "%d %d %d", &numV3, &numT3, &dummy); //두번째 줄에서 꼭지점 개수, 삼각형 개수, 의미 없는 정보 읽기

	//2. 꼭지점 개수와 삼각형 개수만큼 배열로 메모리 할당
	vx3 = new float[numV3];
	vy3 = new float[numV3];
	vz3 = new float[numV3];

	a3 = new int[numT3];
	b3 = new int[numT3];
	c3 = new int[numT3];

	R3 = new int[numV3];
	G3 = new int[numV3];
	B3 = new int[numV3];
	alpha3 = new int[numV3];

	//3. off파일에서 vertex좌표와 삼각형 정보를 읽어서 전역변수의 배열에 정보 채우기
	//꼭지점 배열 채우기

	for (i = 0; i < numV3; i++) {
		fscanf(fp3, "%f %f %f %d %d %d %d", &vx3[i], &vy3[i], &vz3[i], &R3[i], &G3[i], &B3[i], &alpha3[i]);

		//x,y,z 축 방향으로 꼭지점의 최대 최소값 결정 (바운딩 박스를 잡을 때 사용)
		//원점에서 가장 가까운꼭지점이 min 가장 먼꼭지점이 max
		if (vx3[i] > vx_max3)
			vx_max3 = vx3[i];

		if (vx3[i] < vx_min3)
			vx_min3 = vx3[i];

		if (vy3[i] > vy_max3)
			vy_max3 = vy3[i];

		if (vy3[i] < vy_min3)
			vy_min3 = vy3[i];

		if (vz3[i] > vz_max3)
			vz_max3 = vz3[i];

		if (vz3[i] < vz_min3)
			vz_min3 = vz3[i];
	}

	//삼각형 색인 배열 채우기(a, b, c)
	for (i = 0; i < numT3; i++) {
		fscanf(fp3, "%d %d %d %d %d %d %d", &dummy, &a3[i], &b3[i], &c3[i], &dummy, &dummy, &dummy);
	}
	lmax3 = max(max(vx_max3 - vx_min3, vy_max3 - vy_min3), vz_max3 - vz_min3); //셋 중 가장 큰 값 찾기

	//printf("%f\n", vx[0]); //확인용
	//printf("%d\n", numV); //확인용
	//printf("%d\n", numT);
	//printf("%f", lmax);

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(800, 800);
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	glutCreateWindow("Example");

	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(keyboard); //키보드콜백펑션
	glutMainLoop();

	fclose(fp1);
	fclose(fp2);
	fclose(fp3);
	return 0;
}