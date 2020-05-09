/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50559
Source Host           : 127.0.0.1:3306
Source Database       : achaohomework

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-12-27 18:52:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for abcde
-- ----------------------------
DROP TABLE IF EXISTS `abcde`;
CREATE TABLE `abcde` (
  `date` date DEFAULT NULL,
  `A` int(11) DEFAULT NULL,
  `B` int(11) DEFAULT NULL,
  `C` int(11) DEFAULT NULL,
  `D` int(11) DEFAULT NULL,
  `E` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abcde
-- ----------------------------
INSERT INTO `abcde` VALUES ('2011-12-01', '18', '5', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-02', '6', '70', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-03', '9', '132', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-04', '2', '118', '656', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-05', '5', '116', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-06', '10', '271', '669', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-07', '8', '301', '894', '12', '613');
INSERT INTO `abcde` VALUES ('2011-12-08', '15', '297', '792', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-10', '0', '26', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-11', '0', '129', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-12', '0', '22', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-13', '0', '1', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-14', '0', '17', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-15', '0', '77', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-16', '0', '7', '140', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-09', '7', '218', '643', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-17', '0', '0', '382', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-18', '0', '0', '414', '6', '67');
INSERT INTO `abcde` VALUES ('2011-12-19', '58', '0', '0', '0', '965');
INSERT INTO `abcde` VALUES ('2011-12-20', '232', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-21', '0', '232', '1141', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-22', '272', '0', '141', '11', '971');
INSERT INTO `abcde` VALUES ('2011-12-23', '222', '103', '804', '0', '854');
INSERT INTO `abcde` VALUES ('2011-12-24', '161', '0', '56', '0', '456');
INSERT INTO `abcde` VALUES ('2011-12-25', '174', '18', '603', '0', '588');
INSERT INTO `abcde` VALUES ('2011-12-26', '320', '0', '148', '5', '1097');
INSERT INTO `abcde` VALUES ('2011-12-27', '256', '0', '0', '0', '372');
INSERT INTO `abcde` VALUES ('2011-12-28', '89', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2011-12-29', '144', '0', '0', '0', '331');
INSERT INTO `abcde` VALUES ('2011-12-31', '184', '0', '56', '12', '961');
INSERT INTO `abcde` VALUES ('2012-01-01', '18', '5', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-02', '6', '70', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-03', '9', '132', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-04', '2', '118', '656', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-05', '5', '116', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-06', '10', '271', '669', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-07', '8', '301', '894', '12', '613');
INSERT INTO `abcde` VALUES ('2012-01-08', '15', '297', '792', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-09', '7', '218', '643', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-10', '0', '26', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-11', '0', '129', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-12', '0', '22', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-13', '0', '1', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-14', '0', '17', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-15', '0', '77', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-16', '0', '7', '140', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-17', '0', '0', '382', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-18', '0', '0', '414', '6', '67');
INSERT INTO `abcde` VALUES ('2012-01-19', '58', '0', '0', '0', '965');
INSERT INTO `abcde` VALUES ('2012-01-20', '232', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-21', '0', '222', '1141', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-22', '272', '0', '141', '11', '971');
INSERT INTO `abcde` VALUES ('2012-01-23', '222', '103', '804', '0', '854');
INSERT INTO `abcde` VALUES ('2012-01-24', '161', '0', '56', '0', '456');
INSERT INTO `abcde` VALUES ('2012-01-25', '174', '18', '603', '0', '588');
INSERT INTO `abcde` VALUES ('2012-01-26', '320', '0', '148', '5', '1097');
INSERT INTO `abcde` VALUES ('2012-01-27', '256', '0', '0', '0', '372');
INSERT INTO `abcde` VALUES ('2012-01-28', '89', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-01-29', '144', '0', '0', '0', '331');
INSERT INTO `abcde` VALUES ('2012-01-31', '184', '0', '56', '12', '961');
INSERT INTO `abcde` VALUES ('2012-02-01', '18', '5', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-02', '6', '70', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-03', '9', '132', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-04', '2', '118', '656', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-05', '5', '116', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-06', '10', '271', '669', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-07', '8', '301', '894', '12', '613');
INSERT INTO `abcde` VALUES ('2012-02-08', '186', '297', '848', '12', '961');
INSERT INTO `abcde` VALUES ('2012-02-09', '7', '218', '773', '2', '229');
INSERT INTO `abcde` VALUES ('2012-02-10', '0', '26', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-11', '0', '129', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-12', '0', '22', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-13', '0', '1', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-14', '0', '17', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-15', '0', '77', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-16', '0', '7', '140', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-17', '0', '0', '382', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-18', '0', '0', '414', '6', '67');
INSERT INTO `abcde` VALUES ('2012-02-19', '58', '0', '0', '0', '965');
INSERT INTO `abcde` VALUES ('2012-02-20', '232', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-21', '0', '222', '1141', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-22', '272', '0', '141', '11', '971');
INSERT INTO `abcde` VALUES ('2012-02-23', '222', '103', '804', '0', '854');
INSERT INTO `abcde` VALUES ('2012-02-24', '161', '0', '56', '0', '456');
INSERT INTO `abcde` VALUES ('2012-02-25', '174', '18', '603', '0', '588');
INSERT INTO `abcde` VALUES ('2012-02-26', '320', '0', '148', '5', '1097');
INSERT INTO `abcde` VALUES ('2012-02-27', '256', '0', '0', '0', '372');
INSERT INTO `abcde` VALUES ('2012-02-28', '102', '0', '0', '0', '0');
INSERT INTO `abcde` VALUES ('2012-02-29', '144', '0', '0', '0', '705');
INSERT INTO `abcde` VALUES ('2012-03-01', '308', '284', '936', '6', '1032');
INSERT INTO `abcde` VALUES ('2012-03-02', '278', '292', '1282', '11', '971');
INSERT INTO `abcde` VALUES ('2012-03-03', '231', '235', '804', '0', '854');
INSERT INTO `abcde` VALUES ('2012-03-04', '163', '118', '712', '0', '456');
INSERT INTO `abcde` VALUES ('2012-03-05', '179', '134', '603', '0', '588');
INSERT INTO `abcde` VALUES ('2012-03-06', '330', '271', '817', '5', '1097');
INSERT INTO `abcde` VALUES ('2012-03-07', '264', '301', '894', '12', '985');
INSERT INTO `abcde` VALUES ('2012-03-08', '288', '297', '848', '12', '961');
INSERT INTO `abcde` VALUES ('2012-03-09', '151', '218', '773', '2', '934');
INSERT INTO `abcde` VALUES ('2012-01-30', '0', '0', '130', '2', '603');
INSERT INTO `abcde` VALUES ('2011-12-30', '0', '0', '130', '2', '603');
