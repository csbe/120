package ch.csbe.exam.controller;

public class Second extends Controller{
	protected void next(){
		new Navigator().navigate(new First());
	}
}
