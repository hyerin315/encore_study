var app = new Vue({
    el: '#app-7',
    data: {
        value: 0,
        isChecked: true,
        header: '튜토리얼7 : v-else-if 임혜린',
        message: 'v-else-if는 렌더링을 제어하는 지시자입니다',
        message1: 'v-if와 같이 사용하는 지시자입니다',
        message2: '좋아하는 과일을 선택하세요',
        label1: '바나나',
        label2: '딸기',
        label3: '사과',
        label4: '복숭아',
        text1: '바나나가 체크되어 있습니다.',
        text2: '딸기가 체크되어 있습니다.',
        text3: '사과가 체크되어 있습니다.',
        text4: '복숭아가 체크되어 있습니다.',
        text5: '체크되지 않았습니다.',
    },
    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        }
    }
});


