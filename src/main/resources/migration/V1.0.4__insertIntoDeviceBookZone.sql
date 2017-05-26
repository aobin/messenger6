select SLEEP(5);
INSERT INTO `user_role_new` (
  `user_id`,
  `role_id`,
  `create_date`
)
VALUES
  (
    '4',
    '100',
    now()
  );
