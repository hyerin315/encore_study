var app = new Vue({
    el: '#app-5',
    data: {
        isChecked: true,
        header: '튜토리얼5 : v-if 임혜린',
        message: 'v-if는 렌더링을 제어하는 지시자입니다',
        message1: 'v-if인 true경우 렌더링이 되고 false인 경우 렌더링이 되지 않습니다',
        text1: '체크박스가 체크되어 있습니다.',
    },
    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        }
    }
});


