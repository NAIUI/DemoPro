#include "mainwindow.h"

// #pragma execution_character_set("utf-8")

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->progressBar->hide();
    thread = new QThread(this);
}

MainWindow::~MainWindow()
{
    delete ui;
    thread->quit();
    thread->wait();
    delete loginThread;
    delete thread;
}

void MainWindow::on_loginPushButton_clicked()
{
    QString password;
    QString username;
    username= ui->userLineEdit->text();
    password= ui->pwdLineEdit->text();
    if(username.isEmpty() || password.isEmpty()){
        QMessageBox::information(this, "提示", "用户名或密码不能为空");
        return;
    }
    this->setEnabled(false);
    ui->progressBar->show();
//    thread->quit();
//    thread->wait();
//    delete loginThread;
    loginThread = new LoginThread();
    loginThread->username=username;
    loginThread->password=password;
    loginThread->moveToThread(thread);
    connect(this,&MainWindow::startThread,loginThread,&LoginThread::startConnect);
    connect(loginThread,&LoginThread::loginFailed,this,&MainWindow::loginFailed);
    connect(loginThread,&LoginThread::loginSuccess,this,&MainWindow::loginSuccess);
    emit startThread();
    thread->start();

}
void MainWindow::loginFailed(){
    QMessageBox::critical(this, "错误", loginThread->errMsg);
    this->setEnabled(true);
    ui->progressBar->hide();
    thread->quit();
    thread->wait();
    delete loginThread;
}
void MainWindow::loginSuccess(){
    QString md5;
    QString token;
    QByteArray bytePwd = ui->pwdLineEdit->text().toLatin1();
    QByteArray bytePwdMd5 = QCryptographicHash::hash(bytePwd, QCryptographicHash::Md5);
    md5.append(bytePwdMd5.toHex());
    QString sign = md5+ui->userLineEdit->text();
    bytePwd = sign.toLatin1();
    bytePwdMd5 = QCryptographicHash::hash(bytePwd, QCryptographicHash::Md5);
    token.append(bytePwdMd5.toHex());
//    home = new Home;
//    home->Token = token;
//    home->userName = ui->userLineEdit->text();
//    home->show();
//    home->startListen();
    this->hide();
}

void MainWindow::on_registPushButton_clicked()
{
    // reg = new RegWindow();
    // reg->show();
}
