INSERT INTO `user` (`user_id`, `email`, `firstname`, `lastname`) VALUES ('1', 'user1@work.com', 'first', 'user');
INSERT INTO `user` (`user_id`, `email`, `firstname`, `lastname`) VALUES ('2', 'user2@work.com', 'second', 'user');
INSERT INTO `patient` (`patient_id`, `first_name`, `height`, `last_name`) VALUES ('1', 'the', '56', 'patient');
INSERT INTO `diagnosis_form` (`diag_id`, `symptoms`, `treatment`, `doctor_id`, `nurse_id`, `patient_id`) VALUES ('1', 'sick', 'medicine', '1', '2', '1');