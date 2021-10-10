const qnaList = [
    {
        q: '님을 보면 생각나는 계절은?',
        a: [
            { answer: '봄', type: 'spring' },
            { answer: '여름', type: 'summer' },
            { answer: '가을', type: 'autumn' },
            { answer: '겨울', type: 'winter' },
        ]
    },
    {
        q: '님의 성별은?',
        a: [
            { answer: '여성', type: '_female' },
            { answer: '남성', type: '_male' },
        ]
    },
    {
        q: '님의 나이가 어떻게 되나요?',
        a: [
            { answer: '25세 미만', type: '25under' },
            { answer: '25세 이상', type: '25older' },
        ]
    }, //계절+성별+나이 컬럼
    {
        q: '님은 활동적인가요?',
        a: [
            { answer: '활기차다, 밝다!', type: 'daynight=1' },
            { answer: '차분하고 조용하다!', type: 'daynight=2' },
        ]
    }, //daynight 컬럼
    {
        q: '님을 보면 생각나는 분위기는?',
        a: [
            { answer: '여성스러운', type: 'floral' },
            { answer: '상큼달콤한', type: 'fruity' },
            { answer: '눈에 서 꿀 떨어지는 달달한 사람', type: 'sweet' },
            { answer: '자연 친화적인', type: 'green' },
            { answer: '숲의 아이', type: 'woody' },
            { answer: '바닷가처럼 시원한', type: ' aquatic' },

        ]
    },
    {
        q: '님에게 독특한 향을 줄까요?',
        a: [
            { answer: '베스트 아이템을 선물로 줄래.', type: 'rating_score>4'},
            { answer: '독특한게 좋아.', type: 'rating_score<4' },
        ]
    }, // rating_score컬럼 4이상인것
    {
        q: '님에게 지속성에 대한 중요도는?',
        a: [
            { answer: '지속성이 긴게 좋지.', type: 'longevity>=4'},
            { answer: '지속성 약한게 좋아.', type: 'longevity<4' },
        ]
    }, // 
    {
        q: '님에게 잔향에 대한 중요도는?',
        a: [
            { answer: '잔향이 강한게 좋을 것 같아.', type: 'sillage>=2'},
            { answer: '잔향이 약한게 좋을 것 같아.', type: 'sillage=1' },
        ]
    }, 
];

const data = {qnaList}
export default data