package com.tghr.comm.util;

import org.springframework.data.domain.Sort;

public final class PageRequest {

    private int page;
    private int size;
    private String searchparam;
    private Sort.Direction direction;
    

    public PageRequest(int page, int size, String searchparam, String strdirection) {
		super();
		this.setPage(page);
		this.setSize(size);
		this.searchparam = searchparam;
		this.setDirection(Sort.Direction.fromString(strdirection));
	}

	public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }
    
    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page -1, size, direction, searchparam);
    }
}