var app = new Vue({
    el: '#app-t2',
    data: {
        header: '콤보박스',
        age: 2000,
        month: 12,
        day: 31,

        selected: "",
        items: [
            "item1", "item2", "item3", "item4"
        ]

    }
});
function handleOnChange(e) {
    // 선택된 데이터 가져오기
    const value = e.value;
    
    // 데이터 출력
    document.getElementById('result').innerText
    = value;
}
