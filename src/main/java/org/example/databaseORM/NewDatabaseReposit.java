package org.example.databaseORM;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.example.Course.Course;
import org.example.Course.Module;
import org.example.Course.Task;
import org.example.ScourOfCourse.*;
import org.example.VKAPI.VkPerson;
import org.example.databaseORM.DbModelsTask.MaxScoresFromGender;
import org.example.databaseORM.DbModelsTask.ModulesDb;
import org.example.databaseORM.DbModelsTask.TaskDb;
import org.example.databaseORM.DbModelsTask.TaskStudentScores;
import org.example.databaseORM.VkDb.StudentEntity;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewDatabaseReposit{
    private final String URL =  "jdbc:sqlite:java.db";
    private Dao<StudentEntity, String> studentDao = null;
    private Dao<ModulesDb, String> modulesDao = null;

    private Dao<TaskDb, String> taskDbDao = null;

    private ConnectionSource connectionSource = null;

    public void connect() throws SQLException{
        connectionSource = new JdbcConnectionSource(URL);
        studentDao = DaoManager.createDao(connectionSource, StudentEntity.class);
        modulesDao = DaoManager.createDao(connectionSource, ModulesDb.class);
        taskDbDao = DaoManager.createDao(connectionSource, TaskDb.class);

    }

    public void createStudentTable() throws SQLException{
        TableUtils.createTable(connectionSource, StudentEntity.class);
    }



    public void dropStudentTable() throws SQLException{
        TableUtils.dropTable(connectionSource, StudentEntity.class, false);
    }



    public void saveStudents(ArrayList<VkPerson> vkPersons, ArrayList<Person> persons) throws SQLException{
        for (var student : vkPersons){
            for (var person : persons) {
                if (student.getName().equals(person.getStudentName())){
                    if(student.getSex() == null){
                        if(person.getGender() != null) {
                            studentDao.create(new StudentEntity(student.getName(), person.getGroup(), person.getGender()));
                        }
                    }

                    if(student.getSex()!= null) {
                        studentDao.create(new StudentEntity(student.getName(),person.getGroup(), student.getSex()));
                    }
                }
            }
        }
    }



    public List<StudentEntity> getStudents() throws SQLException{
        return studentDao.queryForAll();
    }



    public void createModulesTable() throws SQLException{
        TableUtils.createTable(connectionSource, ModulesDb.class);
    }



    public void dropModulesTable() throws SQLException{
        TableUtils.dropTable(connectionSource, ModulesDb.class, false);
    }



    public void saveModules(ArrayList<Student> students, Course course,  List<StudentEntity> studentsE) throws SQLException{
            ArrayList<Module> modularised = course.getModulesFromCourse();

            for(var i : modularised){
                        var moduleName = i.getModuleName();
                        var max = i.getMaxScore().getScoreOfExercises() + i.getMaxScore().getScoreOfHomeworks();
                        var maxScore = getCountBestStudentsModules(students, course,  studentsE, i.getModuleName());
                        var m = allScoreFromstudentsModules(students, studentsE, course, i.getModuleName());
                        modulesDao.create(new ModulesDb(moduleName, max, m.getMaxScore(), m.getMaxScoremale(),
                                maxScore.getCountStudentHaveMaxScore(), maxScore.getCountStudentHaveMaxScoreMale(),
                                maxScore.getCountSudentDontHaveMAxScore(), maxScore.getCountSudentDontHaveMAxScoreMale(),
                                maxScore.getCountStudentHaveZeroScore(), maxScore.getCountStudentHaveZeroScoreMale()));



            }

    }

    public TaskStudentScores getCountBestStudentsModules(ArrayList<Student> students, Course course,  List<StudentEntity> studentEntities, String modulen) {
        int countMax = 0;
        int countNotMax = 0;
        int countZero = 0;
        int countMaxMale = 0;
        int countNotMaxMale = 0;
        int countZeroMale = 0;
        var modulelisCourse = course.getModulesFromCourse();
        for (var i : students) {
            for (var vk : studentEntities) {
                if (vk.getName().equals(i.getStudentName())) {
                    var modulelist = i.getCourseScore().getModulesScoreCourse();
                    for (var q : modulelist) {
                        for (var module : modulelisCourse) {
                            if (q.getModuleName().equals(modulen) & module.getModuleName().equals(modulen)) {
                                var maxScore = module.getMaxScore().getScoreOfExercises() + module.getMaxScore().getScoreOfHomeworks();
                                var maxScoreStudents = q.getMaxScore().getScoreOfExercises() + q.getMaxScore().getScoreOfHomeworks();
                                if (vk.getGender().equals("MALE")) {
                                    if (maxScoreStudents == maxScore) {
                                        countMaxMale++;
                                    } else if (maxScoreStudents == 0) {
                                        countZeroMale++;


                                    } else {
                                        countNotMaxMale++;
                                    }
                                }

                                if (vk.getGender().equals("FEMALE")) {
                                    if (maxScoreStudents == maxScore) {
                                        countMax++;
                                    } else if (maxScoreStudents == 0) {
                                        countZero++;

                                    } else {
                                        countNotMax++;
                                    }
                                }
                            }
                        }
                    }
                }


            }
        }

        return new TaskStudentScores(countMax, countMaxMale, countNotMax, countNotMaxMale, countZero,   countZeroMale);

    }

    public TaskStudentScores getCountBestStudents(ArrayList<Student> students, Course course, String taskname, List<StudentEntity> studentEntities) {
        int countMax = 0;
        int countNotMax = 0;
        int countZero = 0;
        int countMaxMale = 0;
        int countNotMaxMale = 0;
        int countZeroMale = 0;
        var modulelisCourse = course.getModulesFromCourse();
        for (var i : students) {
            for (var vk : studentEntities) {
                var modulelist = i.getCourseScore().getModulesScoreCourse();
                for (var q : modulelist) {
                    if (vk.getName().equals(i.getStudentName())) {
                        for (var module : modulelisCourse) {
                            if (q.getModuleName().equals(module.getModuleName())) {
                                var taskScores = q.getTasks();
                                var taskCourse = module.getTasks();
                                for (var task : taskScores) {
                                    for (Task tascourse : taskCourse) {
                                        if (taskname.equals(task.getTaskName()) && tascourse.getTaskName().equals(taskname)) {
                                            if (vk.getGender().equals("MALE")) {
                                                if (task.getScores() == tascourse.getMaxScores()) {
                                                    countMaxMale++;
                                                } else if (task.getScores() == 0) {
                                                    countZeroMale++;

                                                } else {
                                                    countNotMaxMale++;
                                                }
                                            }

                                            if (vk.getGender().equals("FEMALE")) {
                                                if (task.getScores() == tascourse.getMaxScores()) {
                                                    countMax++;
                                                } else if (task.getScores() == 0) {
                                                    countZero++;
                                                } else {
                                                    countNotMax++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return new TaskStudentScores(countMax, countMaxMale, countNotMax, countNotMaxMale, countZero,   countZeroMale);

    }

    public MaxScoresFromGender allScoreFromstudentsModules(ArrayList<Student> students,  List<StudentEntity> studentEntities, Course course, String m) {
        int maxscores = 0;
        int maxscoresMale = 0;
        var module = course.getModulesFromCourse();
        for (var s : studentEntities) {
            for (var i : students) {
                var modulelist = i.getCourseScore().getModulesScoreCourse();
                for (var c1 : module) {
                    for (var q : modulelist) {
                        if(c1.getModuleName().equals(q.getModuleName()) & c1.getModuleName().equals(m)) {
                            if (s.getName().equals(i.getStudentName())) {
                                if (s.getGender().equals("MALE")) {
                                    maxscoresMale = maxscoresMale + q.getMaxScore().getScoreOfExercises() + q.getMaxScore().getScoreOfHomeworks();
                                } else {
                                    maxscores = maxscores + q.getMaxScore().getScoreOfExercises() + q.getMaxScore().getScoreOfHomeworks();
                                }
                            }
                        }
                    }

                }
            }
        }

        return new MaxScoresFromGender(maxscores, maxscoresMale);
    }

    public MaxScoresFromGender allScoreFromstudents(ArrayList<Student> students, String taskname, List<StudentEntity> studentEntities) {
        int maxscores = 0;
        int maxscoresMale = 0;
        for (var s : studentEntities) {
            for (var i : students) {
                var modulelist = i.getCourseScore().getModulesScoreCourse();
                for (var q : modulelist) {
                    var taskScores = q.getTasks();
                    for (var task : taskScores) {
                        if (taskname.equals(task.getTaskName())) {
                            if(s.getName().equals(i.getStudentName())) {
                                if(s.getGender().equals("MALE")) {
                                    maxscoresMale = maxscoresMale + task.getScores();
                                }
                                else{
                                    maxscores = maxscores + task.getScores();
                                }
                            }
                        }
                    }
                }
            }
        }

        return new MaxScoresFromGender(maxscores, maxscoresMale);

    }

    public List<ModulesDb> getModules() throws SQLException{
        return modulesDao.queryForAll();
    }

    public void CreateTableTaskDb() throws SQLException{
        TableUtils.createTable(connectionSource, TaskDb.class);
    }

    public void DropTableTaskDb() throws SQLException{
        TableUtils.dropTable(connectionSource, TaskDb.class, false);
    }

    public void SaveTaskDb(ArrayList<Student> students, List<ModulesDb>  modulesDbs,  Course course, List<StudentEntity> studentEntities) throws SQLException {
        for (var name : modulesDbs){
               for (var moduleCourse : course.getModulesFromCourse()) {
                   String modulename2 = moduleCourse.getModuleName();
                   if (name.getModulenamedb().equals(modulename2)){
                       for (var task : moduleCourse.getTasks()) {
                           TaskStudentScores ts = getCountBestStudents(students, course, task.getTaskName(), studentEntities);
                           taskDbDao.create(new TaskDb(task.getTaskName(), task.getTasktype(), name.getModulenamedb(),
                                   task.getMaxScores() ,
                                   allScoreFromstudents(students, task.getTaskName(), studentEntities).getMaxScore(),
                                   allScoreFromstudents(students, task.getTaskName(), studentEntities).getMaxScoremale(),
                                   ts.getCountStudentHaveMaxScore(), ts.getCountStudentHaveMaxScoreMale(),
                                   ts.getCountSudentDontHaveMAxScore(), ts.getCountSudentDontHaveMAxScoreMale(),
                                   ts.getCountStudentHaveZeroScore(), ts.getCountStudentHaveZeroScoreMale()));

                       }
                   }
               }
        }
    }







    public List<TaskDb> getTaskDd() throws SQLException{
        return taskDbDao.queryForAll();
    }
    public void close() throws Exception{
        connectionSource.close();
    }
}
