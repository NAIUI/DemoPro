#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "loginthread.h"
#include "ui_mainwindow.h"
// #include "regwindow.h"
// #include "home.h"

#include <QString>
#include <QMessageBox>
#include <QDebug>
#include <QByteArray>
#include <QCryptographicHash>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void on_loginPushButton_clicked();

    void on_registPushButton_clicked();

private:
    Ui::MainWindow *ui;
    // RegWindow* reg;
    void loginFailed();
    void loginSuccess();
    LoginThread* loginThread;
    QThread* thread;
    // Home* home;
signals:
    void startThread();
};

#endif // MAINWINDOW_H
