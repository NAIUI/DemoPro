/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QProgressBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralWidget;
    QGridLayout *gridLayout;
    QHBoxLayout *horizontalLayout;
    QPushButton *loginPushButton;
    QPushButton *registPushButton;
    QSpacerItem *horizontalSpacer;
    QFormLayout *formLayout;
    QLabel *userNameLabel;
    QLineEdit *userLineEdit;
    QLabel *pwdLlabel;
    QLineEdit *pwdLineEdit;
    QSpacerItem *verticalSpacer_2;
    QSpacerItem *verticalSpacer_3;
    QVBoxLayout *verticalLayout;
    QLabel *label_3;
    QProgressBar *progressBar;
    QSpacerItem *verticalSpacer;
    QSpacerItem *horizontalSpacer_2;
    QMenuBar *menuBar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->setEnabled(true);
        MainWindow->resize(465, 300);
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(MainWindow->sizePolicy().hasHeightForWidth());
        MainWindow->setSizePolicy(sizePolicy);
        MainWindow->setMinimumSize(QSize(465, 300));
        MainWindow->setMaximumSize(QSize(471, 300));
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        MainWindow->setWindowIcon(icon);
        centralWidget = new QWidget(MainWindow);
        centralWidget->setObjectName(QString::fromUtf8("centralWidget"));
        gridLayout = new QGridLayout(centralWidget);
        gridLayout->setSpacing(0);
        gridLayout->setContentsMargins(11, 11, 11, 11);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setSpacing(6);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        loginPushButton = new QPushButton(centralWidget);
        loginPushButton->setObjectName(QString::fromUtf8("loginPushButton"));
        QFont font;
        font.setFamily(QString::fromUtf8("\345\276\256\350\275\257\351\233\205\351\273\221"));
        loginPushButton->setFont(font);

        horizontalLayout->addWidget(loginPushButton);

        registPushButton = new QPushButton(centralWidget);
        registPushButton->setObjectName(QString::fromUtf8("registPushButton"));
        registPushButton->setFont(font);

        horizontalLayout->addWidget(registPushButton);


        gridLayout->addLayout(horizontalLayout, 6, 1, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer, 6, 0, 1, 1);

        formLayout = new QFormLayout();
        formLayout->setSpacing(6);
        formLayout->setObjectName(QString::fromUtf8("formLayout"));
        formLayout->setHorizontalSpacing(7);
        formLayout->setVerticalSpacing(7);
        userNameLabel = new QLabel(centralWidget);
        userNameLabel->setObjectName(QString::fromUtf8("userNameLabel"));
        userNameLabel->setFont(font);

        formLayout->setWidget(0, QFormLayout::LabelRole, userNameLabel);

        userLineEdit = new QLineEdit(centralWidget);
        userLineEdit->setObjectName(QString::fromUtf8("userLineEdit"));
        userLineEdit->setMinimumSize(QSize(0, 25));
        userLineEdit->setFont(font);

        formLayout->setWidget(0, QFormLayout::FieldRole, userLineEdit);

        pwdLlabel = new QLabel(centralWidget);
        pwdLlabel->setObjectName(QString::fromUtf8("pwdLlabel"));
        pwdLlabel->setFont(font);

        formLayout->setWidget(1, QFormLayout::LabelRole, pwdLlabel);

        pwdLineEdit = new QLineEdit(centralWidget);
        pwdLineEdit->setObjectName(QString::fromUtf8("pwdLineEdit"));
        pwdLineEdit->setMinimumSize(QSize(0, 25));
        pwdLineEdit->setFont(font);
        pwdLineEdit->setEchoMode(QLineEdit::Password);

        formLayout->setWidget(1, QFormLayout::FieldRole, pwdLineEdit);


        gridLayout->addLayout(formLayout, 4, 1, 1, 1);

        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer_2, 2, 1, 1, 1);

        verticalSpacer_3 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer_3, 7, 0, 1, 1);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setSpacing(0);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(-1, -1, -1, 0);
        label_3 = new QLabel(centralWidget);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        sizePolicy.setHeightForWidth(label_3->sizePolicy().hasHeightForWidth());
        label_3->setSizePolicy(sizePolicy);
        label_3->setMinimumSize(QSize(469, 77));
        label_3->setMaximumSize(QSize(469, 77));
        label_3->setStyleSheet(QString::fromUtf8("background-image: url(:/image/ban.png);"));

        verticalLayout->addWidget(label_3);

        progressBar = new QProgressBar(centralWidget);
        progressBar->setObjectName(QString::fromUtf8("progressBar"));
        progressBar->setEnabled(true);
        QSizePolicy sizePolicy1(QSizePolicy::Expanding, QSizePolicy::Fixed);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(progressBar->sizePolicy().hasHeightForWidth());
        progressBar->setSizePolicy(sizePolicy1);
        progressBar->setMinimumSize(QSize(0, 10));
        progressBar->setMaximumSize(QSize(16777215, 12));
        progressBar->setStyleSheet(QString::fromUtf8("QProgressBar::chunk {\n"
"background-color: rgb(0, 85, 127);\n"
"}"));
        progressBar->setMinimum(0);
        progressBar->setMaximum(0);
        progressBar->setValue(0);
        progressBar->setTextVisible(false);
        progressBar->setInvertedAppearance(false);

        verticalLayout->addWidget(progressBar);


        gridLayout->addLayout(verticalLayout, 0, 0, 1, 3);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        gridLayout->addItem(verticalSpacer, 5, 1, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        gridLayout->addItem(horizontalSpacer_2, 6, 2, 1, 1);

        MainWindow->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(MainWindow);
        menuBar->setObjectName(QString::fromUtf8("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 465, 23));
        MainWindow->setMenuBar(menuBar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "\347\231\273\345\275\225", nullptr));
        loginPushButton->setText(QCoreApplication::translate("MainWindow", "\347\253\213\345\215\263\347\231\273\345\275\225", nullptr));
        registPushButton->setText(QCoreApplication::translate("MainWindow", "\346\263\250\345\206\214\350\264\246\345\217\267", nullptr));
        userNameLabel->setText(QCoreApplication::translate("MainWindow", "\347\224\250\346\210\267\345\220\215\357\274\232", nullptr));
        userLineEdit->setText(QCoreApplication::translate("MainWindow", "912394456", nullptr));
        pwdLlabel->setText(QCoreApplication::translate("MainWindow", "\345\257\206\347\240\201\357\274\232", nullptr));
        pwdLineEdit->setText(QCoreApplication::translate("MainWindow", "lzx2000228", nullptr));
        label_3->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
