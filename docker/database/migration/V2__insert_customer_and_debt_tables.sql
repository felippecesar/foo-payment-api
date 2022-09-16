INSERT INTO TB_CUSTOMER (COD_ID, NAM_NAME,COD_DOCUMENT,DES_PRIORITY_NOTIF_WAY,NAM_MAIL,COD_PHONE,DES_ADDRESS,NUM_PROFILE_SCORE)
VALUES
    (1, 'JOAO DA SILVA','12345678900','PUSH','joaodasilva@mock.com','34987654321',null,200),
    (2, 'PEDRO DA SILVA','12345678901','EMAIL','pedrodasilva@mock.com','34987654322',null,600);

INSERT INTO TB_CUSTOMER_DEBT(
    COD_CUSTOMER_ID             ,
    NUM_AMOUNT                  ,
    NUM_MONTHLY_TAX             ,
    DAT_DUE_DATE                ,
    NUM_MAX_OVERDUE_DAYS        ,
    DAT_LAST_NOTIFICATION_DATE  ,
    COD_CREDITOR_DOCUMENT       ,
    COD_NEGOTIATION_TICKET_ID   ,
    DES_STATUS
) VALUES
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (2, 20500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (2, 22500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID');