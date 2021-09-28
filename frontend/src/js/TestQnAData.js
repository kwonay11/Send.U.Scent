const qnaList = [
    {
        q: '1. 좋아하는 계절이 있나요?',
        a: [
<<<<<<< HEAD
            { answer: '봄', type: '0' },
            { answer: '여름', type: '1' },
            { answer: '가을', type: '2' },
            { answer: '겨울', type: '3' },
=======
            { answer: '봄', type: 'spring_' },
            { answer: '여름', type: 'summer_' },
            { answer: '가을', type: 'autumn_' },
            { answer: '겨울', type: 'winter_' },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        ]
    },
    {
        q: '2. 성별은?',
        a: [
<<<<<<< HEAD
            { answer: '여성', type: 1 },
            { answer: '남성', type: 0 },
=======
            { answer: '여성', type: 'female' },
            { answer: '남성', type: 'male' },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        ]
    },
    {
        q: '3.나이가 어떻게 되나요?',
        a: [
<<<<<<< HEAD
            { answer: '25세 미만', type: 0 },
            { answer: '25세 이상', type: 1 },
=======
            { answer: '25세 미만', type: '25under' },
            { answer: '25세 이상', type: '25older' },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        ]
    }, //계절+성별+나이 컬럼
    {
        q: '4. 향수를 뿌리고 싶은 시간은?',
        a: [
<<<<<<< HEAD
            { answer: '해가 떠 있는 밝은 낮에', type: 0 },
            { answer: '헤가 진 고요한 밤에', type: 1 },
=======
            { answer: '해가 떠 있는 밝은 낮에', type: 'daynight=1' },
            { answer: '해가 진 고요한 밤에', type: 'daynight=2' },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        ]
    }, //daynight 컬럼
    {
        q: '5. 끌리는 분위기는?',
        a: [
<<<<<<< HEAD
            { answer: '꽃밭에 누워있는', type: 0 },
            { answer: '상큼한 과일을 베어 문', type: 1 },
            { answer: '숲 속에 서 있는', type: 2 },
            { answer: '사탕을 한 입 가득', type: 3 },
=======
            { answer: '꽃밭에 누워있는', type: 'floral' },
            { answer: '상큼한 과일을 베어 문', type: 'citrus' },
            { answer: '숲 속에 서 있는', type: 'woody' },
            { answer: '사탕을 한 입 가득', type: 'sweet' },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630

        ]
    },
    {
        q: '6. 대중의 평가가 중요한가요?',
        a: [
<<<<<<< HEAD
            { answer: '인기 많은 것엔 다 이유가 있는 법.', type: 0 },
            { answer: '사람들의 평과와는 상관 없어.', type: 1 },
        ]
    }, // rating_score컬럼
=======
            { answer: '인기 많은 것엔 다 이유가 있는 법.', type: 'rating_score>4'},
            { answer: '독특한게 좋아.', type: 'rating_score<4' },
        ]
    }, // rating_score컬럼 4이상인것
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
];

const data = {qnaList}
export default data