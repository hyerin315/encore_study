var app = new Vue({
    el: '#app-9',
    data: {
        enemyHP: 10,
        attack: 2,
        recovery: 1,
        header: '튜토리얼9 : v-on 임혜린',
        message: 'v-on은 이벤트를 처리하는 렌더링 지시자입니다',
        label1: '공격',
        label2: '회복'
    },
    methods: {
        onClickAttack: function () {
            this.enemyHP -= this.attack;

            if(this.enemyHP <= 0)
            {
                this.enemyHP =0;
            }
        },
        onClickRecovery: function() {
            this.enemyHP += this.recovery;
        }
    }
});
