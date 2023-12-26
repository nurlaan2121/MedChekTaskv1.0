package main.models;

import java.util.*;

public class Department extends Hospital implements List<Hospital> {
    private Long id;
    private String departmentName;
    private LinkedList<Doctor> doctors = new LinkedList<>();

    public Department() {
    }

    public Department(Long id, String departmentName, LinkedList<Doctor> doctors) {
        this.id = id;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LinkedList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(LinkedList<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Hospital> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Hospital hospital) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Hospital> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Hospital> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Hospital get(int index) {
        return null;
    }

    @Override
    public Hospital set(int index, Hospital element) {
        return null;
    }

    @Override
    public void add(int index, Hospital element) {

    }

    @Override
    public Hospital remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Hospital> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Hospital> listIterator(int index) {
        return null;
    }

    @Override
    public List<Hospital> subList(int fromIndex, int toIndex) {
        return null;
    }
}
