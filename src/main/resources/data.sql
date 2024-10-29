insert into user (user_id, email, group_name, nickname, password, profile_image, provider, provider_id, username, role) values (1, 'guri8376@gmail.com', NULL, 'guri', '$2a$10$YdUD4z.bWxeaNnVkwup4eOwUI9oGUaJBZCIlyJfRqCHBVYRKl7vBO', 'http://dummyimage.com/183x100.png/cc0000/ffffff', 'google', '112352185765074384097', 'google_112352185765074384097', 'ROLE_GUEST');

insert into board (board_id, user_id, title, content, image_url, recruit_end_date, start_date, project_period, recruitment_status, view_count, comment_count, created_at, last_modified_at) values (1, 1, 'Aerified', 'clechmere0@hud.gov', 'http://dummyimage.com/183x100.png/cc0000/ffffff', '2024-10-27 23:16:57', '2024-10-27 23:16:57', 1, 'RECRUITING', 0, 0, '2024-10-27 23:16:53.889355', '2024-10-27 23:16:53.889355');
insert into board (board_id, user_id, title, content, image_url, recruit_end_date, start_date, project_period, recruitment_status, view_count, comment_count, created_at, last_modified_at) values (2, 1, 'Stringtough', 'skenafaque1@nih.gov', 'http://dummyimage.com/209x100.png/dddddd/000000', '2024-10-27 23:16:57', '2024-10-27 23:16:57', 2, 'RECRUITING', 0, 0, '2024-10-27 23:16:54.889355', '2024-10-27 23:16:54.889355');
insert into board (board_id, user_id, title, content, image_url, recruit_end_date, start_date, project_period, recruitment_status, view_count, comment_count, created_at, last_modified_at) values (3, 1, 'Quo Lux', 'mbryan2@wired.com', 'http://dummyimage.com/185x100.png/5fa2dd/ffffff', '2024-10-27 23:16:57', '2024-10-27 23:16:57', 3, 'RECRUITING', 0, 0,'2024-10-27 23:16:55.889355', '2024-10-27 23:16:55.889355');
insert into board (board_id, user_id, title, content, image_url, recruit_end_date, start_date, project_period, recruitment_status, view_count, comment_count, created_at, last_modified_at) values (4, 1, 'Zoolab', 'elexa3@va.gov', 'http://dummyimage.com/211x100.png/dddddd/000000', '2024-10-27 23:16:57', '2024-10-27 23:16:57', 4, 'RECRUITING', 0, 0,'2024-10-27 23:16:56.889355', '2024-10-27 23:16:56.889355');
insert into board (board_id, user_id, title, content, image_url, recruit_end_date, start_date, project_period, recruitment_status, view_count, comment_count, created_at, last_modified_at) values (5, 1, 'Duobam', 'kmckenny4@msn.com', 'http://dummyimage.com/172x100.png/cc0000/ffffff', '2024-10-27 23:16:57', '2024-10-27 23:16:57', 5, 'RECRUITING', 0, 0,'2024-10-27 23:16:57.889355', '2024-10-27 23:16:57.889355');

insert into tech_stack (tech_stack_id, tech_stack_name, image_url) values (1, 'JAVA', 'http://dummyimage.com/184x100.png/5fa2dd/ffffff');
insert into tech_stack (tech_stack_id, tech_stack_name, image_url) values (2, 'SPRING', 'http://dummyimage.com/143x100.png/cc0000/ffffff');
insert into tech_stack (tech_stack_id, tech_stack_name, image_url) values (3, 'REACT', 'http://dummyimage.com/128x100.png/5fa2dd/ffffff');
insert into tech_stack (tech_stack_id, tech_stack_name, image_url) values (4, 'VUE', 'http://dummyimage.com/232x100.png/dddddd/000000');
insert into tech_stack (tech_stack_id, tech_stack_name, image_url) values (5, 'AWS', 'http://dummyimage.com/222x100.png/ff4444/ffffff');

insert into position (position_id, position_name) values (1, 'FrontEnd');
insert into position (position_id, position_name) values (2, 'BackEnd');
insert into position (position_id, position_name) values (3, 'Designer');
insert into position (position_id, position_name) values (4, 'Project Manager');
insert into position (position_id, position_name) values (5, 'DevOps Engineer');
insert into position (position_id, position_name) values (6, 'Android Developer');
insert into position (position_id, position_name) values (7, 'IOS Developer');
insert into position (position_id, position_name) values (8, 'Cross Platform Developer');
insert into position (position_id, position_name) values (9, 'Planner');

insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (1, 1, 1, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2024-10-27 23:16:53.889355', '2024-10-27 23:16:53.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (2, 1, 1, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', '2024-10-27 23:16:54.889355', '2024-10-27 23:16:54.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (3, 1, 1, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', '2024-10-27 23:16:55.889355', '2024-10-27 23:16:55.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (4, 1, 1, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', '2024-10-27 23:16:56.889355', '2024-10-27 23:16:56.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (5, 1, 1, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', '2024-10-27 23:16:57.889355', '2024-10-27 23:16:57.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (6, 1, 2, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', '2024-10-27 23:16:58.889355', '2024-10-27 23:16:58.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (7, 1, 2, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2024-10-27 23:16:59.889355', '2024-10-27 23:16:59.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (8, 1, 2, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2024-10-27 23:17:00.889355', '2024-10-27 23:17:00.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (9, 1, 2, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '2024-10-27 23:17:01.889355', '2024-10-27 23:17:01.889355');
insert into comment (comment_id, user_id, board_id, content, created_at, last_modified_at) values (10, 1, 2, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '2024-10-27 23:17:02.889355', '2024-10-27 23:17:02.889355');

insert into user_position (user_position_id, user_id, position_id) values (1, 1, 1);
insert into user_position (user_position_id, user_id, position_id) values (2, 1, 2);
insert into user_position (user_position_id, user_id, position_id) values (3, 1, 3);
insert into user_position (user_position_id, user_id, position_id) values (4, 1, 4);
insert into user_position (user_position_id, user_id, position_id) values (5, 1, 5);

insert into user_tech_stack (user_tech_stack_id, user_id, tech_stack_id) values (1, 1, 1);
insert into user_tech_stack (user_tech_stack_id, user_id, tech_stack_id) values (2, 1, 2);
insert into user_tech_stack (user_tech_stack_id, user_id, tech_stack_id) values (3, 1, 3);
insert into user_tech_stack (user_tech_stack_id, user_id, tech_stack_id) values (4, 1, 4);
insert into user_tech_stack (user_tech_stack_id, user_id, tech_stack_id) values (5, 1, 5);

-- DDL: 게시글 당 댓글 2개, 포지션