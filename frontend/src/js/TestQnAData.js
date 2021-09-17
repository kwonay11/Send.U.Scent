const qnaList = [
    {
        q: '1. 좋아하는 계절이 있나요?',
        a: [
            { answer: '봄', type: 0 },
            { answer: '여름', type: 1 },
            { answer: '가을', type: 2 },
            { answer: '겨울', type: 3 },
        ]
    },
    {
        q: '2. 성별은?,',
        a: [
            { answer: '여성', type: 1 },
            { answer: '남성', type: 0 },
        ]
    },
    {
        q: '3.나이가 어떻게 되나요?',
        a: [
            { answer: '25세 미만', type: 0 },
            { answer: '25세 이상', type: 1 },
        ]
    }, //계절+성별+나이 컬럼
    {
        q: '4. 평소에 자주 이용하는 운송수단은?',
        a: [
            { answer: '대중교통', type:  0},
            { answer: '자가용', type: 1},
        ]
    }, //지속성 컬럼
    {
        q: '5. 향수를 뿌리고 싶은 시간은?,',
        a: [
            { answer: '해가 떠 있는 밝은 낮에', type: 0 },
            { answer: '헤가 진 고요한 밤에', type: 1 },
        ]
    }, //daynight 컬럼
    {
        q: '6. 끌리는 분위기는?',
        a: [
            { answer: '꽃밭에 누워있는,', type: 0 },
            { answer: '상큼한 과일을 베어 문', type: 1 },
            { answer: '숲 속에 서 있는', type: 2 },
            { answer: '사탕을 한 입 가득', type: 3 },
            { answer: '시원한 바닷가를 거니는', type: 4 },

        ]
    },
    {
        q: '7. 대중의 평가가 중요한가요?',
        a: [
            { answer: '인기 많은 것엔 다 이유가 있는 법.', type: 0 },
            { answer: '사람들의 평과와는 상관 없어.', type: 1 },
        ]
    }, // rating_score컬럼
];

const data = {qnaList}
export default data