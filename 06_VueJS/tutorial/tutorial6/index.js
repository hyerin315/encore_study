var app = new Vue({
    el: '#app-6',
    data: {
        isChecked: true,
        header: '튜토리얼6 : v-else 임혜린',
        message: 'v-else은 v-if와 같이 사용하는 지시자입니다',
        message1: 'v-if인 true이면 v-else는 false이고, v-if가 false인 경우 v-else는 ture 입니다',
        text1: '체크박스가 체크되어 있습니다.',
        text2: '체크박스가 체크되어 있지 않습니다.'
    },
    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        }
    }
});


