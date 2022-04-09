package com.jasper.grpc.service;

import com.jasper.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BlogServiceImpl extends BlogServiceGrpc.BlogServiceImplBase {
	@Override
	public void getArticles(GetArticlesRequest request, StreamObserver<GetArticlesResponse> response) {
		GetArticlesResponse.Builder builder = GetArticlesResponse.newBuilder();
		builder.addItems(getArticle(1));
		builder.addItems(getArticle(2));
		builder.setExtra(Extra.newBuilder().setPage(1).setSize(10).setTotal(100).build());
		response.onNext(builder.build());
		response.onCompleted();
	}

	private Article getArticle(int num) {
		Article.Builder builder = Article.newBuilder();
		builder.setId("article-" + num);
		builder.setTitle("Article - " + num);
		builder.setCoverImage("");
		Category category = Category.newBuilder().setId(1).setName("Java").build();
		builder.setCategory(category);
		return builder.build();
	}
}
