CREATE CONSTRAINT ON (`person`:`Person`) ASSERT `person`.`id` IS UNIQUE
CREATE CONSTRAINT ON (`asset`:`Asset`) ASSERT `asset`.`uuid` IS UNIQUE
CREATE CONSTRAINT ON (`acted_in`:`ACTED_IN`) ASSERT `acted_in`.`id` IS UNIQUE
CREATE CONSTRAINT ON (`model2`:`Model2`) ASSERT `model2`.`id` IS UNIQUE
CREATE CONSTRAINT ON (`composite3`:`Composite3`) ASSERT (`composite3`.`accountNumber`,`composite3`.`accountType`) IS NODE KEY
CREATE CONSTRAINT ON (`model3`:`Model3`) ASSERT `model3`.`id` IS UNIQUE
CREATE CONSTRAINT ON (`movie`:`Movie`) ASSERT `movie`.`id` IS UNIQUE
CREATE CONSTRAINT ON (`model1`:`Model1`) ASSERT `model1`.`id` IS UNIQUE
