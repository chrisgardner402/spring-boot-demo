CREATE TABLE IF NOT EXISTS `demo_transaction_log` (
  `t_id` varchar(128) NOT NULL,
  `t_code` char(3) NOT NULL,
  `t_msg` text NOT NULL,
  `t_data` mediumtext DEFAULT NULL,
  `t_len` int(11) DEFAULT NULL,
  `t_timestamp` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
