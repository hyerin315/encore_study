var app = new Vue({
    el: '#app-4',
    data: {
        isChecked: true,
        header: '튜토리얼4 : v-show',
        message: 'v-show는 CSS의 display프로퍼티를 제어하는 지시자 입니다',
        message1: 'v-show가 true인 경우 텍스트가 표시되고 false인 경우 텍스트가 표시되지 않습니다',
        message2: 'css display가 none이 아닌 경우 텍스트가 표시됩니다',
        message3: 'css display가 none인 경우 텍스트가 표시되지 않습니다',
        text1: '체크박스가 체크되어 있습니다.',
        text2: 'css display가 none이 아닙니다',
        text3: 'css display가 none입니다'
    },
    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        }
    }
});


