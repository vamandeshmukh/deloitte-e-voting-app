package com.deloitte.service;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;

import com.deloitte.exception.AlreadyVotedException;
import com.deloitte.exception.IncorrectLoginCredentialsException;
import com.deloitte.exception.InvalidAadhaarException;
import com.deloitte.exception.InvalidEmailException;
import com.deloitte.exception.InvalidGenderException;
import com.deloitte.exception.InvalidMobileNumberException;
import com.deloitte.exception.InvalidNameException;
import com.deloitte.exception.InvalidPincodeException;
import com.deloitte.exception.NoSuchCandidateRecordException;
import com.deloitte.exception.NoSuchConstituencyException;
import com.deloitte.exception.NoSuchRecordException;
import com.deloitte.exception.NoSuchVoterException;
import com.deloitte.exception.NotScheduledException;
import com.deloitte.exception.UnauthorisedVoterException;
import com.deloitte.exception.UnderAgeException;
import com.deloitte.model.Candidates;
import com.deloitte.model.Election;
import com.deloitte.model.Party;
import com.deloitte.model.Pincode;
import com.deloitte.model.Voter;

public interface VoterService {

	public boolean addVoter(Voter voter) throws InvalidEmailException, UnderAgeException, InvalidNameException,
			InvalidPincodeException, InvalidMobileNumberException, InvalidAadhaarException, InvalidGenderException;

	public Voter loginVoter(long aadhaar, String password)
			throws IncorrectLoginCredentialsException, NoSuchVoterException, InvalidAadhaarException;

	public Voter viewVoter(long aadhaar) throws NoSuchVoterException, InvalidAadhaarException;

	public List<Election> viewSchedule() throws NoSuchRecordException;

	public List<Party> viewParty() throws NoSuchRecordException;

	public List<Candidates> viewCandidates() throws NoSuchRecordException;

	public List<Candidates> viewCandidatesByConstituency(long aadhaar)
			throws NoSuchRecordException, InvalidAadhaarException;

	public String voteCasting(String epic, int candidateId)
			throws NotScheduledException, NoSuchCandidateRecordException, AlreadyVotedException,
			UnauthorisedVoterException, NoSuchVoterException, NotScheduledException;

	public String viewVoteForAllCandidate() throws NoSuchRecordException;

	public String viewVoteForAllParty() throws NoSuchRecordException;

	public String viewVoteForConstituency(int constituency) throws NoSuchRecordException, NoSuchConstituencyException;

	public List<Pincode> findPincodeByState(String State) throws NoSuchRecordException;
	
	public void MailService(JavaMailSender javaMailSender);

	public void sendEmail(String to, String subject, String body);
}
