import sys                     # 시스템 접근 모듈
from PyQt5.QtWidgets import *  # 윈도우 창 만들기 모듈
from PyQt5 import uic          # pyqt로 만든 창 사용 모듈

form_class = uic.loadUiType('mywindow.ui')[0]  # ui 읽어오기,  [0]은 문법

# 확장성을 고려한 윈도우 창 설계 변경
class MyWindow(QMainWindow, form_class):   # 클래스를 상속받아 구성
    def __init__(self):        # 생성자
        super().__init__()     # 부모의 생성자 사용
        self.setupUi(self)     # ui 띄우기
        self.pushButton.clicked.connect(self.btn_clicked)  # 버튼을 클릭하면 매서드 호출

    def btn_clicked(self):
        print("버튼 클릭")
        
app = QApplication(sys.argv)   # 윈도우 창 객체 생성
window = MyWindow()            # 객체를 활용
window.show()                  # 객체를 통한 매서드 접근
app.exec_()                    # 윈도우 창 객체 실행
