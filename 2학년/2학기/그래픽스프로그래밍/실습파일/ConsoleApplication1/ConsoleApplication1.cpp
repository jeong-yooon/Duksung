#include <GL/GLUT.H>
#include <math.h>
#define Pi 3.14

void display(void) {

	GLfloat size[2];
	GLfloat step;
	GLfloat curSize;
	GLfloat angle;
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0, 1.0, 1.0);
	glGetFloatv(GL_POINT_SIZE_RANGE, size);
	glGetFloatv(GL_POINT_SIZE_GRANULARITY, &step);
	curSize = size[0];

	double rad = 0.5;

	glBegin(GL_POINTS);
	for (angle = 0.0; angle <= 2.0 * Pi; angle += Pi / 30.0) {

		glPointSize(curSize);
		glBegin(GL_POINTS);
		glVertex3f(rad * cos(angle), rad * sin(angle), 0.0);
		glEnd();
		curSize += step;
	}
	glEnd();
	glFlush();
}

int main(int argc, char** argv) {

	//glutInit(&argc, argv);
	//glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutCreateWindow("example");
	glutDisplayFunc(display);
	glutMainLoop();
	return 0;
}