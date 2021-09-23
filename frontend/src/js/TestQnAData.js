const qnaList = [
    {
        q: '1. 좋아하는 계절이 있나요?',
        a: [
            { answer: '봄', type: 'spring_' },
            { answer: '여름', type: 'summer_' },
            { answer: '가을', type: 'autumn_' },
            { answer: '겨울', type: 'winter_' },
        ]
    },
    {
        q: '2. 성별은?',
        a: [
            { answer: '여성', type: 'female' },
            { answer: '남성', type: 'male' },
        ]
    },
    {
        q: '3.나이가 어떻게 되나요?',
        a: [
            { answer: '25세 미만', type: '25under' },
            { answer: '25세 이상', type: '25older' },
        ]
    }, //계절+성별+나이 컬럼
    {
        q: '4. 향수를 뿌리고 싶은 시간은?',
        a: [
            { answer: '해가 떠 있는 밝은 낮에', type: 'daynight=1' },
            { answer: '해가 진 고요한 밤에', type: 'daynight=2' },
        ]
    }, //daynight 컬럼
    {
        q: '5. 끌리는 분위기는?',
        a: [
            { answer: '꽃밭에 누워있는', type: 'floral' },
            { answer: '상큼한 과일을 베어 문', type: 'citrus' },
            { answer: '숲 속에 서 있는', type: 'woody' },
            { answer: '사탕을 한 입 가득', type: 'sweet' },

        ]
    },
    {
        q: '6. 대중의 평가가 중요한가요?',
        a: [
            { answer: '인기 많은 것엔 다 이유가 있는 법.', type: 'rating_score>4'},
            { answer: '독특한게 좋아.', type: 'rating_score<4' },
        ]
    }, // rating_score컬럼 4이상인것
];

const data = {qnaList}
export default data