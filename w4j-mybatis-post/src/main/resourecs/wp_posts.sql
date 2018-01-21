
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `wp_posts`;
CREATE TABLE `wp_posts`  (
  `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_author` bigint(20) UNSIGNED NOT NULL DEFAULT 0,
  `post_date` datetime(0) NULL,
  `post_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_title` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'publish',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `type_status_date`(`post_status`, `post_date`, `ID`) USING BTREE,
  INDEX `post_author`(`post_author`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章基础信息表，包含了日志，附件，页面等等信息'
  ROW_FORMAT = Dynamic;


INSERT INTO `wp_posts` VALUES (2, 1, '2017-09-20 14:33:46', '这是示范页面。页面和博客文章不同，它的位置是固定的，通常会在站点导航栏显示。很多用户都创建一个“关于”页面，向访客介绍自己。例如：\n\n<blockquote>欢迎！我白天是个邮递员，晚上就是个有抱负的演员。这是我的博客。我住在天朝的帝都，有条叫做Jack的狗。</blockquote>\n\n……或这个：\n\n<blockquote>XYZ Doohickey公司成立于1971年，自从建立以来，我们一直向社会贡献着优秀doohickies。我们的公司总部位于天朝魔都，有着超过两千名员工，对魔都政府税收有着巨大贡献。</blockquote>\n\n而您，作为一个WordPress用户，我们建议您访问<a href=\"http://localhost:8082/wordpress/wp-admin/\">控制板</a>，删除本页面，然后添加您自己的页面。祝您使用愉快！', '示例页面', 'publish');
INSERT INTO `wp_posts` VALUES (4, 1, '2017-09-28 23:53:13', '第一篇文章，文章内容', '第一篇文章，文章标题', 'publish');
INSERT INTO `wp_posts` VALUES (5, 1, '2017-09-28 23:53:13', '第一篇文章，文章内容', '第一篇文章，文章标题', 'inherit');
INSERT INTO `wp_posts` VALUES (7, 1, '2017-09-29 00:12:12', '', '自动草稿', 'auto-draft');
INSERT INTO `wp_posts` VALUES (9, 1, '2017-09-29 00:14:06', '', '自动草稿', 'auto-draft');

SET FOREIGN_KEY_CHECKS = 1;
