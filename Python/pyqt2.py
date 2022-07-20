import sys                     # 시스템 접근 모듈
from PyQt5.QtWidgets import *  # 윈도우 창 만들기 모듈

# 확장성을 고려한 윈도우 창 설계 변경
class MyWindow(QMainWindow):   # 클래스를 상속받아 구성
    def __init__(self):        # 생성자
        super().__init__()     # 부모의 생성자 사용

app = QApplication(sys.argv)   # 윈도우 창 객체 생성
window = MyWindow()            # 객체를 활용
window.show()                  # 객체를 통한 매서드 접근
app.exec_()                    # 윈도우 창 객체 실행

