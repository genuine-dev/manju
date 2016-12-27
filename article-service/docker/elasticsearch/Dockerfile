FROM elasticsearch

RUN plugin install license
RUN plugin install marvel-agent
RUN plugin install analysis-kuromoji

EXPOSE 9200

CMD ["elasticsearch"]
