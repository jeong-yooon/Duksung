#include <Windows.h>
#include<stdio.h>
#include<GL/GLUT.H>
#include<GL/GL.H>
#include<GL/GLU.H>
#pragma warning (disable:4996)

void display(void) {

    float xc = (vx_max + vx_min) / 2.0f;
    float yc = (vy_max + vy_min) / 2.0f;
    float zc = (vz_max + vz_min) / 2.0f;

    float lz = vz_max - vz_min;
    float ly = vy_max - vy_min;
    float lx = vx_max - vx_min;

    glViewport(0, 0, 800, 800);
    glColor3f(1.0f, 1.0f, 1.0f);


    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glMatrixMode(GL_MODELVIEW);
    glShadeModel(GL_SMOOTH);
    gluLookAt(10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 10.0f, 1.0f, 0.0f);

    glLoadIdentity();
    glPushMatrix();

    glRotatef(rot_z, 1, 0, 0);
    glRotatef(rot_y, 0, 1, 0);
    glRotatef(rot_x, 0, 0, 1);

    float lmax = max(max(lx, ly), lz);
    glScalef(1.0f / lmax, 1.0f / lmax, 1.0f / lmax);

    glTranslatef(10.0f + tx, 0.0f + ty, 0.0f + tz);


    glBegin(GL_TRIANGLES);
    for (int Tindex = 0; Tindex < numT; Tindex++) {
        glColor3f(R[a[Tindex]] / 255.0, G[a[Tindex]] / 255.0, B[a[Tindex]] / 255.0);
        glVertex3f(vx[a[Tindex]], vy[a[Tindex]], vz[a[Tindex]]);
        glColor3f(R[b[Tindex]] / 255.0, G[b[Tindex]] / 255.0, B[b[Tindex]] / 255.0);
        glVertex3f(vx[b[Tindex]], vy[b[Tindex]], vz[b[Tindex]]);
        glColor3f(R[c[Tindex]] / 255.0, G[c[Tindex]] / 255.0, B[c[Tindex]] / 255.0);
        glVertex3f(vx[c[Tindex]], vy[c[Tindex]], vz[c[Tindex]]);
    }
    // glVertex3f(-0.1 + trans_left, -0.1 + trans_up, 0.0);
    //glVertex3f(0.1 + trans_left, -0.1 + trans_up, 0.0);
    //glVertex3f(0.1 + trans_left, 0.1 + trans_up, 0.0);
    //glVertex3f(-0.1 + trans_left, 0.1 + trans_up, 0.0);
    glEnd();

    float lmaxv = max(max(lx, ly), lz);

    glScalef(2.0f / lmaxv, 2.0f / lmaxv, 2.0f / lmaxv);

    glRotatef(rot_z, 1, 0, 0);
    glRotatef(rot_y, 0, 1, 0);
    glRotatef(rot_x, 0, 0, 1);

    glTranslatef(10.0f + tx, 0.0f + ty, 0.0f + tz);

    glBegin(GL_TRIANGLES);
    for (int Hindex = 0; Hindex < numTT; Hindex++) {
        glColor3f(Rr[aa[Hindex]] / 255.0, Gg[aa[Hindex]] / 255.0, Bb[aa[Hindex]] / 255.0);
        glVertex3f(vxv[aa[Hindex]], vyv[aa[Hindex]], vzv[aa[Hindex]]);
        glColor3f(Rr[bb[Hindex]] / 255.0, Gg[bb[Hindex]] / 255.0, Bb[bb[Hindex]] / 255.0);
        glVertex3f(vxv[bb[Hindex]], vyv[bb[Hindex]], vzv[bb[Hindex]]);
        glColor3f(Rr[cc[Hindex]] / 255.0, Gg[cc[Hindex]] / 255.0, Bb[cc[Hindex]] / 255.0);
        glVertex3f(vxv[cc[Hindex]], vyv[cc[Hindex]], vzv[cc[Hindex]]);
    }
    glEnd();

    float lmaxvv = max(max(lx, ly), lz);

    glScalef(0.4f / lmaxvv, 0.4f / lmaxvv, 0.4f / lmaxvv);

    glRotatef(rot_z, 1, 0, 0);
    glRotatef(rot_y, 0, 1, 0);
    glRotatef(rot_x, 0, 0, 1);

    glTranslatef(10.0f + tx, 0.0f + ty, 0.0f + tz);

    glBegin(GL_TRIANGLES);
    for (int Bindex = 0; Bindex < numTTT; Bindex++) {
        glColor3f(Rrr[aaa[Bindex]] / 255.0, Ggg[aaa[Bindex]] / 255.0, Bbb[aaa[Bindex]] / 255.0);
        glVertex3f(vxvv[aaa[Bindex]], vyvv[aaa[Bindex]], vzvv[aaa[Bindex]]);
        glColor3f(Rrr[bbb[Bindex]] / 255.0, Ggg[bbb[Bindex]] / 255.0, Bbb[bbb[Bindex]] / 255.0);
        glVertex3f(vxvv[bbb[Bindex]], vyvv[bbb[Bindex]], vzvv[bbb[Bindex]]);
        glColor3f(Rrr[ccc[Bindex]] / 255.0, Ggg[ccc[Bindex]] / 255.0, Bbb[ccc[Bindex]] / 255.0);
        glVertex3f(vxvv[ccc[Bindex]], vyvv[ccc[Bindex]], vzvv[ccc[Bindex]]);
    }
    glEnd();

    glShadeModel(GL_FLAT);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHTING);
    glEnable(GL_LIGHT0);

    float light_pos[4] = { 2.0f,2.0f,2.0f,1.0f };
    glLightfv(GL_LIGHT0, GL_POSITION, light_pos);
    glPopMatrix();

    glutSwapBuffers();
}