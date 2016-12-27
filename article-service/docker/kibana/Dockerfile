FROM kibana

RUN kibana plugin --install elasticsearch/marvel/latest
RUN kibana plugin --install elastic/sense
EXPOSE 5601
CMD ["kibana"]
