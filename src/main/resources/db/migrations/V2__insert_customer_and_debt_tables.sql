INSERT INTO TB_CUSTOMER (COD_ID, NAM_NAME,COD_DOCUMENT,DES_PRIORITY_NOTIF_WAY,NAM_MAIL,COD_PHONE,DES_ADDRESS,NUM_PROFILE_SCORE)
VALUES
    (1, 'ANDRE DA SILVA1','12345678901','EMAIL','andredasilva1@mock.com','34987654321',null,200),
    (2, 'BRUNA DA SILVA2','12345678902','PUSH','brunadasilva2@mock.com','34987654322',null,600),
    (3, 'CARLOS DA SILVA3','12345678903','LETTER','joaodasilva3@mock.com','34987654321',null,200),
    (4, 'DUDA DA SILVA4','12345678904','SMS','pedrodasilva4@mock.com','34987654322',null,600),
    (5, 'ELAINE DA SILVA5','12345678905','PUSH','joaodasilva5@mock.com','34987654321',null,200),
    (6, 'FELIPE DA SILVA6','12345678906','EMAIL','felipedasilva6@mock.com','34987654322',null,600);

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
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (1, 10500.00, 1.5, current_date - INTERVAL '10 DAY', 30, null, '12345678', null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '1 DAY', 10, null, null, null, 'UNPAID'),
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (1, 10500.00, 1.5, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (1, 11500.00, 1.5, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (2, 20500.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (2, 22500.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (2, 20500.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (2, 22500.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (2, 20500.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (2, 22500.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, null, null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, null, null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (3, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (4, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (4, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (4, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (4, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (4, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (4, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345678', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345678', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID'),
    (5, 20000.00, 1.0, current_date - INTERVAL '1 DAY', 30, null, '12345679', null, 'UNPAID'),
    (5, 10000.00, 1.0, current_date - INTERVAL '10 DAY', 10, null, '12345679', null, 'UNPAID');