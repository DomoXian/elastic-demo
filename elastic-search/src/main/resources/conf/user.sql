SELECT * FROM user
WHERE gmt_modified>date_add(:sql_last_value,INTERVAL 8 HOUR)