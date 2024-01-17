-- 코드를 입력하세요
SELECT USED_GOODS_BOARD.TITLE, USED_GOODS_REPLY.BOARD_ID,USED_GOODS_REPLY.REPLY_ID, USED_GOODS_REPLY.WRITER_ID, USED_GOODS_REPLY.CONTENTS, DATE_FORMAT(USED_GOODS_REPLY.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_REPLY INNER JOIN USED_GOODS_BOARD ON USED_GOODS_REPLY.BOARD_ID = USED_GOODS_BOARD.BOARD_ID
WHERE USED_GOODS_BOARD.CREATED_DATE < CONVERT('2022-11-01',DATE)
ORDER BY USED_GOODS_REPLY.CREATED_DATE, USED_GOODS_BOARD.TITLE;