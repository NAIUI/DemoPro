/********************************************************************************
** Form generated from reading UI file 'biaoqingselect.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BIAOQINGSELECT_H
#define UI_BIAOQINGSELECT_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QTableWidget>

QT_BEGIN_NAMESPACE

class Ui_BiaoqingSelect
{
public:
    QTableWidget *tableWidget;

    void setupUi(QDialog *BiaoqingSelect)
    {
        if (BiaoqingSelect->objectName().isEmpty())
            BiaoqingSelect->setObjectName(QString::fromUtf8("BiaoqingSelect"));
        BiaoqingSelect->resize(591, 449);
        tableWidget = new QTableWidget(BiaoqingSelect);
        if (tableWidget->columnCount() < 8)
            tableWidget->setColumnCount(8);
        if (tableWidget->rowCount() < 8)
            tableWidget->setRowCount(8);
        tableWidget->setObjectName(QString::fromUtf8("tableWidget"));
        tableWidget->setGeometry(QRect(0, 0, 591, 451));
        tableWidget->setRowCount(8);
        tableWidget->setColumnCount(8);
        tableWidget->horizontalHeader()->setVisible(false);
        tableWidget->horizontalHeader()->setMinimumSectionSize(25);
        tableWidget->horizontalHeader()->setDefaultSectionSize(70);
        tableWidget->horizontalHeader()->setHighlightSections(true);
        tableWidget->verticalHeader()->setVisible(false);
        tableWidget->verticalHeader()->setMinimumSectionSize(25);
        tableWidget->verticalHeader()->setDefaultSectionSize(70);
        tableWidget->verticalHeader()->setHighlightSections(true);

        retranslateUi(BiaoqingSelect);

        QMetaObject::connectSlotsByName(BiaoqingSelect);
    } // setupUi

    void retranslateUi(QDialog *BiaoqingSelect)
    {
        BiaoqingSelect->setWindowTitle(QCoreApplication::translate("BiaoqingSelect", "\351\200\211\346\213\251\350\241\250\346\203\205", nullptr));
    } // retranslateUi

};

namespace Ui {
    class BiaoqingSelect: public Ui_BiaoqingSelect {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BIAOQINGSELECT_H
