var app = new Vue({
    el: '#app-8',
    data: {
        value: 0,
        isChecked: true,
        header: '튜토리얼8 : v-for 임혜린',
        message: 'v-for은 배열이나 리스트를 연속해서 보여주는 렌더링 지지자입니다.',
        message1: '카테고리를 선택하세요',
        label1: '꽃',
        label2: '음식',
        label3: '국가',
        label4: '색상',
        flowerList: ['무궁화', '튤립', '장미', '해바라기'],
        foodList: ['김밥', '마라탕', '탕수육', '짜장면'],
        nationList: ['한국', '미국', '캐나다', '일본'],
        colorList: ['파랑', '빨강', '노랑', '초록'],
    },
    methods: {
        onClickCheckButton: function (e) {
            this.isChecked = e.target.checked
        }
    }
});
